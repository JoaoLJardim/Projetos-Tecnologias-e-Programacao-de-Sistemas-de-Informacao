package org.example;

import com.google.gson.Gson;

public class TelemetryDataPoint {

    public double temperature;
    public double humidity;

    public TelemetryDataPoint(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    // Serialize object to JSON format.
    public String serialize() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
