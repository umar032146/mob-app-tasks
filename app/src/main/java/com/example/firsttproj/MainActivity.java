package com.example.firsttproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the new activity
               setContentView(R.layout.activity_main);
                EditText edit = findViewById(R.id.edt);
                EditText edit2 = findViewById(R.id.edt2);
                Button button = findViewById(R.id.button);
                EditText Url = findViewById(R.id.editURL);
                Button openurl = findViewById(R.id.openurl);
                Button openview;
                openview = findViewById(R.id.viewtask);
                Button openmenu = findViewById(R.id.menuopen);
                Button fragments = findViewById(R.id.fragment);

                fragments.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         Intent inteee = new Intent(MainActivity.this, com.example.firsttproj.fragments.class);
                         startActivity(inteee);
                    }
                });

                openmenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(MainActivity.this, Linearview.class);
                        startActivity(intent2);

                    }
                });

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String input = edit.getText().toString().trim();
                        String input2 = edit2.getText().toString().trim();
                        if (input.isEmpty() || input2.isEmpty()) {
                            edit.setError("textfield is empty");
                        } else {
                            Intent intent = new Intent(MainActivity.this, Output.class);
                            intent.putExtra("input", input);
                            intent.putExtra("input2", input2);
                            startActivity(intent);
                        }
                    }

                });
                openurl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       String urlstring = Url.getText().toString().trim();
                       if (!urlstring.isEmpty()){
                           if (!urlstring.startsWith("http://") && !urlstring.startsWith("https://")){
                               urlstring = "http://"+ urlstring;
                           }
                         Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(urlstring));
                           startActivity(intent2);
                       }else{
                           Url.setError("Url is empty");
                       }
                    }
                });

                openview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent3 = new Intent(MainActivity.this, Output.class);
                        startActivity(intent3);
                    }
                });
                }
        }, 2000);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.covermenu, menu);
        return true;
    }


    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Update layout when orientation changes
        setLayoutBasedOnOrientation();
    }

    private void setLayoutBasedOnOrientation() {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.lzndscape_main);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

}