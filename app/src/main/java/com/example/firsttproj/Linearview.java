package com.example.firsttproj;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toolbar;

public class Linearview extends AppCompatActivity{

    LinearLayout cover;
    Button toggle;

   Boolean isopen = false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewlayout);
         toggle = findViewById(R.id.toggle);
         cover = findViewById(R.id.covermenu);

         toggle.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toggle();
             }
         });

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.covermenu, menu);
      return true;
    }

public void Toggle(){
        if (isopen == false){
            cover.setVisibility(View.VISIBLE);
            isopen=true;
        }else {
            cover.setVisibility(View.GONE);
            isopen=false;
        }



}

}


