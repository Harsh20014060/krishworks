package com.tech.krishwork;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder dialogbuilder;
    AlertDialog dialog;
    WebView webView;
    ImageView imageView;
    EditText code1, code2, code3, code4, code5, code6;
    Button home, about_us, updates;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.gearicon);
        home = findViewById(R.id.home_tab);
        about_us = findViewById(R.id.aboutus_tab);
        updates = findViewById(R.id.updates_tab);
        webView = findViewById(R.id.home_url);

        webView.getSettings().setJavaScriptEnabled(true);

        setHome();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createdialog();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                home.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                about_us.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                about_us.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                updates.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                updates.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));

                setHome();

            }
        });
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("https://krishworks.com/about/");

                home.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                home.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                about_us.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                about_us.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                updates.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                updates.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
            }
        });

        updates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("https://krishworks.com/updates/");

                home.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                home.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                about_us.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                about_us.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                updates.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                updates.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
            }
        });

    }

    private void setHome() {
        webView.loadUrl("https://krishworks.com/");

    }

    public void createdialog() {
        dialogbuilder = new AlertDialog.Builder(this);
        View popwindow = getLayoutInflater().inflate(R.layout.pop, null);

        code1 = popwindow.findViewById(R.id.passcode1);
        code2 = popwindow.findViewById(R.id.passcode2);
        code3 = popwindow.findViewById(R.id.passcode3);
        code4 = popwindow.findViewById(R.id.passcode4);
        code5 = popwindow.findViewById(R.id.passcode5);
        code6 = popwindow.findViewById(R.id.passcode6);

        code6.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int action_id, KeyEvent keyEvent) {
                if (action_id == EditorInfo.IME_ACTION_DONE) {
                    String passcode = code1.getText().toString() +
                            code2.getText().toString() +
                            code3.getText().toString() +
                            code4.getText().toString() +
                            code5.getText().toString() +
                            code6.getText().toString();

                    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                    System.out.println("date  " + date);
                    //2022-05-13

                    String[] passcode_create = date.toString().split("-");
                    int final_passcode = Integer.parseInt(passcode_create[0]) * Integer.parseInt(passcode_create[1]) * Integer.parseInt(passcode_create[2]);
                    if (final_passcode == Integer.parseInt(passcode)) {
                        dialog.dismiss();
                        startActivity(new Intent(MainActivity.this, Gear_Icon.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Use Today's Date", Toast.LENGTH_SHORT).show();
                    }


                }
                return false;
            }
        });

        dialogbuilder.setView(popwindow);
        dialog = dialogbuilder.create();
        dialog.show();
    }

}