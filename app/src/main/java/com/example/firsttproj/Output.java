package com.example.firsttproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Output extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);
        TextView output=findViewById(R.id.outputview);
        TextView output2=findViewById(R.id.outputview2);
        String outputtext= getIntent().getStringExtra("input");
        String outputtext2= getIntent().getStringExtra("input2");
        output.setText(outputtext);
        output2.setText(outputtext2);
        Button button = findViewById(R.id.backbut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back =new Intent(Output.this, MainActivity.class);
                startActivity(back);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.covermenu, menu);
        return true;
    }
}
