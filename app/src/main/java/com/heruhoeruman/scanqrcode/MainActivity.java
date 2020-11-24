package com.heruhoeruman.scanqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void btngenerate (View view) {
            Intent btngenerate = new Intent(MainActivity.this, GenerateActivity.class);
            startActivity(btngenerate);
        }

    public void btnscan (View view) {
        Intent btnscan = new Intent(MainActivity.this, ScanActivity.class);
        startActivity(btnscan);
    }
}