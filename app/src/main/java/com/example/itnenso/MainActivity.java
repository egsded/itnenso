package com.example.itnenso;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                Intent it1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
                startActivity(it1);
                break;
            case R.id.btn2:
                Intent itc = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:8714175266"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    //TODO: Consider calling
                    //ActivityCompat#requestPermissions
                    //here to request the missing permissions, and then overriding
                    return;
                }
                startActivity(itc);
                break;
            case R.id.btn3:
                Intent itn = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pinterest.com.mx"));
                startActivity(itn);
                break;
            case R.id.btn4:
                Intent itg = new Intent();
                itg.setAction(Intent.ACTION_VIEW);
                itg.setType("image/*");
                itg.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(itg);
                break;
            case R.id.btn5:
                Intent itf = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/<Facebook Page ID"));
                startActivity(itf);
                break;
            case R.id.btn6:
                Intent ity = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+ "PWWBbQRCiLQ"));
                ity.putExtra("VIDEO_ID", "PWWBbQRCiLQ");
                startActivity(ity);
                break;
            case R.id.btn7:
                Intent itb = new Intent(Intent.ACTION_SEND);
                itb.putExtra("Mensaje","pifi");
                itb.setType("text/plain");
                startActivity(Intent.createChooser(itb, "Elije una app"));
                break;
        }
    }
}
