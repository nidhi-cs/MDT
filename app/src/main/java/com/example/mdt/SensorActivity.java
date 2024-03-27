package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;


public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private Sensor accelerometerSensor;
    private Sensor gyroscopeSensor;
    private TextView proximityTextView;
    private TextView accelerometerTextView;
    private TextView gyroscopeTextView;

    private Button stopButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        proximityTextView = findViewById(R.id.txtValues);
        accelerometerTextView = findViewById(R.id.txtAccelerometerValues);
        gyroscopeTextView = findViewById(R.id.txtGyroscopeValues);
        stopButton = findViewById(R.id.btnStop);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if (proximitySensor == null) {
            Toast.makeText(this, "Proximity sensor not available", Toast.LENGTH_SHORT).show();
        }
        if (accelerometerSensor == null) {
            Toast.makeText(this, "Accelerometer sensor not available", Toast.LENGTH_SHORT).show();
        }
        if (gyroscopeSensor == null) {
            Toast.makeText(this, "Gyroscope sensor not available", Toast.LENGTH_SHORT).show();
        }

    stopButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v){
        stopSensorUpdates();
        Toast.makeText(SensorActivity.this, "Sensor updates stopped", Toast.LENGTH_SHORT).show();
    }
    });
}

    @Override
    protected void onResume() {
        super.onResume();
        if (proximitySensor != null) {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (accelerometerSensor != null) {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (gyroscopeSensor != null) {
            sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (proximitySensor != null) {
            sensorManager.unregisterListener(this, proximitySensor);
        }
        if (accelerometerSensor != null) {
            sensorManager.unregisterListener(this, accelerometerSensor);
        }
        if (gyroscopeSensor != null) {
            sensorManager.unregisterListener(this, gyroscopeSensor);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            proximityTextView.setText(" PROXIMITY Values: " + event.values[0]);
            if (event.values[0] > 0) {
                Toast.makeText(this, "Object is Near", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Object is Far", Toast.LENGTH_SHORT).show();
            }
        } else if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            accelerometerTextView.setText(" ACCELEROMETER Values: " + event.values[0] + ", " + event.values[1] + ", " + event.values[2]);
        } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            gyroscopeTextView.setText(" GYROSCOPE Values: " + event.values[0] + ", " + event.values[1] + ", " + event.values[2]);
        }
    }
    private void stopSensorUpdates() {
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not needed for this example
    }

    public void startAnotherActivity(View view) {
        Intent intent = new Intent(this, Sensor.class);
        startActivity(intent);
    }
}


