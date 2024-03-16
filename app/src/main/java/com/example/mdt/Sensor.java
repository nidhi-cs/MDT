package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Sensor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
    }
    public void startSensorActivity(View view) {
        Intent intent = new Intent(this,Sensor.class);
        startActivity(intent);
    }
}