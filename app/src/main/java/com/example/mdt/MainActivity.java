package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mobileInfoBtn;
    private Button batteryInfoBtn;
    private Button cameraInfoBtn;
    private Button networkInfoBtn;
    private Button sensorInfoBtn;
    private Button displayInfoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all buttons
        mobileInfoBtn = findViewById(R.id.MobileInfoBtn);
        batteryInfoBtn = findViewById(R.id.batteryInfoBtn);
        cameraInfoBtn = findViewById(R.id.cameraInfoBtn);
        networkInfoBtn = findViewById(R.id.networkInfoBtn);
        sensorInfoBtn = findViewById(R.id.sensorInfoBtn);
        displayInfoBtn = findViewById(R.id.displayInfoBtn);

        // Set OnClickListener for mobileInfoBtn
        mobileInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMobileActivity();
            }
        });

        // Set OnClickListener for batteryInfoBtn
        batteryInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBatteryActivity();
            }
        });

        // Set OnClickListener for cameraInfoBtn
        cameraInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCameraActivity();
            }
        });

        // Set OnClickListener for networkInfoBtn
        networkInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNetworkActivity();
            }
        });

        // Set OnClickListener for sensorInfoBtn
        sensorInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSensorActivity();
            }
        });

        displayInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDisplayActivity();
            }

        });
    }

    private void startMobileActivity() {
        Intent intent = new Intent(this, Mobile.class);
        startActivity(intent);
    }

    private void startBatteryActivity() {
        Intent intent = new Intent(this, Battery.class);
        startActivity(intent);
    }

    private void startCameraActivity() {
        Intent intent = new Intent(this, Camera.class);
        startActivity(intent);
    }

    private void startNetworkActivity() {
        Intent intent = new Intent(this, Network.class);
        startActivity(intent);
    }

    private void startSensorActivity() {
        Intent intent = new Intent(this, SensorActivity.class);
        startActivity(intent);
    }
        private void startDisplayActivity () {
            Intent intent = new Intent(this, Display.class);
            startActivity(intent);
        }
    }

