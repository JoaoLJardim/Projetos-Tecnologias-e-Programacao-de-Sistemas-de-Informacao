package com.example.ficha8android;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button increaseButton;
    private TextView textViewTemp;
    private int temperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatura = 22;
        increaseButton = findViewById(R.id.buttonIncrease);
        textViewTemp = findViewById(R.id.textViewTemperatura);
        textViewTemp.setText(temperatura);

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperatura++;
                textViewTemp.setText(temperatura);
            }
        });
    }
}
