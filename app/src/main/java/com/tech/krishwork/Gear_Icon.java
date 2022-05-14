package com.tech.krishwork;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Gear_Icon extends AppCompatActivity {

    WebView webView;
    TextView close,setting;
    Button gallary, contact_us;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gear_icon);

        close = findViewById(R.id.close_tab);
        gallary = findViewById(R.id.gallary);
        contact_us = findViewById(R.id.contact_us);
        webView = findViewById(R.id.gal_con_url);

        webView.getSettings().setJavaScriptEnabled(true);

        setgallary();

        gallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gallary.setBackgroundColor(ContextCompat.getColor(Gear_Icon.this, R.color.blue));
                gallary.setTextColor(ContextCompat.getColor(Gear_Icon.this, R.color.yellow));
                contact_us.setBackgroundColor(ContextCompat.getColor(Gear_Icon.this, R.color.white));
                contact_us.setTextColor(ContextCompat.getColor(Gear_Icon.this, R.color.blue));
                setgallary();

            }
        });
        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("https://krishworks.com/contact/");

                contact_us.setBackgroundColor(ContextCompat.getColor(Gear_Icon.this, R.color.blue));
                contact_us.setTextColor(ContextCompat.getColor(Gear_Icon.this, R.color.yellow));
                gallary.setBackgroundColor(ContextCompat.getColor(Gear_Icon.this, R.color.white));
                gallary.setTextColor(ContextCompat.getColor(Gear_Icon.this, R.color.blue));
    
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Gear_Icon.this,MainActivity.class));
            }
        });
    }

    private void setgallary() {
        webView.loadUrl("https://krishworks.com/gallery/");

    }
}