package com.donsmart.simpleunitconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class lengthScreen extends AppCompatActivity {

    EditText etMile,etKilometer;
    Button btnConvertl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_screen);

        getSupportActionBar().setTitle("Unit Converter");

        etMile = findViewById(R.id.etMile);
        etKilometer = findViewById(R.id.etKilometer);
        btnConvertl = findViewById(R.id.btnConvertl);


        btnConvertl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etMile.getText().toString().trim().isEmpty() && etKilometer.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(lengthScreen.this, "Please enter data into one field", Toast.LENGTH_SHORT).show();
                }
                else if (!etKilometer.getText().toString().trim().isEmpty() && etMile.getText().toString().trim().isEmpty())
                {
                    double kilomileConstant = 0.62137119;
                    DecimalFormat decimalFormat = new DecimalFormat("0.0000");
                    double km = Double.parseDouble(etKilometer.getText().toString());
                    double mile = kilomileConstant*km;
                    String roundedMile = decimalFormat.format(mile);

                    etMile.setText(roundedMile);

                }
                else if (etKilometer.getText().toString().trim().isEmpty() && !etMile.getText().toString().trim().isEmpty())
                {
                    double milekiloConstant = 1/0.62137119;
                    DecimalFormat decimalFormat = new DecimalFormat("0.0000");
                    double mile = Double.parseDouble(etMile.getText().toString());
                    double km = mile*milekiloConstant;
                    String roundedKm = decimalFormat.format(km);

                    etKilometer.setText(roundedKm);

                }
                else if (!etKilometer.getText().toString().trim().isEmpty() && !etMile.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(lengthScreen.this, "Value must be entered into only field", Toast.LENGTH_SHORT).show();
                    etKilometer.setText("");
                    etMile.setText("");
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.clearAll)
        {
            etKilometer.setText("");
            etMile.setText("");
            Toast.makeText(this, "All fields cleared", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }



}