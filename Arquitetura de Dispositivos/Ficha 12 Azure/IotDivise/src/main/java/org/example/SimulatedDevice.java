package org.example;

import com.google.gson.Gson;
import com.microsoft.azure.sdk.iot.device.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulatedDevice {
    // The device connection string to authenticate the device with your IoT hub.
    // Using the Azure CLI:
    // az iot hub device-identity show-connection-string --hub-name {YourIoTHubName} --device-id MyJavaDevice --output table
    private static String connString = "";

    // Using the MQTT protocol to connect to IoT Hub
    private static IotHubClientProtocol protocol = IotHubClientProtocol.MQTT;
    private static DeviceClient client;

    public SimulatedDevice() throws URISyntaxException, IOException {
        // Connect to the IoT hub.
        client = new DeviceClient(connString, protocol);
        client.open();

        // Register to receive direct method calls.
        client.subscribeToDeviceMethod(new DirectMethodCallback(), null, new DirectMethodStatusCallback(), null);

        System.out.println("Device connected to hub!");
    }

    public void start() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    sendMessage();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task,0,1000);
    }

    private void sendMessage() throws InterruptedException {
        TelemetryDataPoint data = new TelemetryDataPoint(25,70);
        // Converter para JSON
        String dataJson = data.serialize();

        Message msg = new Message(dataJson);

        Object lockObj = new Object();

        // Send Message
        System.out.println("Sending message:"+ dataJson);
        client.sendEventAsync(msg,new EventCallback(),lockObj);
        synchronized (lockObj) {
            lockObj.wait();
        }


    }


    public static void main(String[] args) {
        try {
            SimulatedDevice device = new SimulatedDevice();

            device.start();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}