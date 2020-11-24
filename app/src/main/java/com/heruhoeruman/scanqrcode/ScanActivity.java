package com.heruhoeruman.scanqrcode;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanActivity extends AppCompatActivity implements View.OnClickListener {
    private Button scanBtn;
    private TextView tvScanFormat, tvScanContent;
    private LinearLayout llSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        scanBtn = (Button) findViewById(R.id.scan_button);
        tvScanFormat = (TextView) findViewById(R.id.tvScanFormat);
        tvScanContent = (TextView) findViewById(R.id.tvScanContent);
        llSearch = (LinearLayout) findViewById(R.id.llSearch);
        scanBtn.setOnClickListener(this);
    }
    public void onClick(View v) {
        llSearch.setVisibility(View.GONE);
        IntentIntegrator integrator = new
                IntentIntegrator(this);
        integrator.setPrompt("Scan QRcode");
        integrator.setOrientationLocked(false);
        integrator.initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                llSearch.setVisibility(View.GONE);
                Toast.makeText(this, "Keluar",
                        Toast.LENGTH_LONG).show();
            } else {
                llSearch.setVisibility(View.VISIBLE);
                tvScanContent.setText(result.getContents());
                Linkify.addLinks(tvScanContent, Linkify.ALL); //menambahkan link
                tvScanFormat.setText(result.getFormatName());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}