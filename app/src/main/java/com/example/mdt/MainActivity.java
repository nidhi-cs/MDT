package com.example.mdt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mobileInfoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mobileInfoBtn = findViewById(R.id.MobileInfoBtn);


        mobileInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDiagnostics(v);    }
        });
    }

    public void startDiagnostics(View view) {
        Intent intent = new Intent(this, Mobile.class);
        startActivity(intent);
    }
}
