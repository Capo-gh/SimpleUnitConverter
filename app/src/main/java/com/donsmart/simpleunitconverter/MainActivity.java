package com.donsmart.simpleunitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvLength,tvMass,tvTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Unit Converter");

        tvLength = findViewById(R.id.tvLength);
        tvMass = findViewById(R.id.tvMass);
        tvTemp = findViewById(R.id.tvTemp);

        tvLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,lengthScreen.class));

            }
        });

        tvMass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,massScreen.class));

            }
        });

        tvTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,temperatureScreen.class));

            }
        });


    }
}