package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Network extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
    }
    public void startNetworkActivity(View view) {
        Intent intent = new Intent(this,Network.class);
        startActivity(intent);
    }
}