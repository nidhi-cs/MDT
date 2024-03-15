package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class  Battery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);
    }
    public void startDiagnostics(View view) {
        Intent intent = new Intent(this,Battery.class);
        startActivity(intent);
    }
}