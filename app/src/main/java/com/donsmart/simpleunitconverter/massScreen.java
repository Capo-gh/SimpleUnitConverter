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

public class massScreen extends AppCompatActivity {

    Button btnConvertm;
    EditText etKilogram,etPound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_screen);

        btnConvertm = findViewById(R.id.btnConvertm);
        etKilogram = findViewById(R.id.etKilogram);
        etPound = findViewById(R.id.etPound);

        btnConvertm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etKilogram.getText().toString().trim().isEmpty() && etPound.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(massScreen.this, "Please enter data into one field", Toast.LENGTH_SHORT).show();
                }
                else if (!etKilogram.getText().toString().trim().isEmpty() && etPound.getText().toString().trim().isEmpty())
                {
                    double kilopoundContant = 2.2046226218;
                    DecimalFormat decimalFormat = new DecimalFormat("0.0000");
                    double kg = Double.parseDouble(etKilogram.getText().toString());
                    double lb = kilopoundContant*kg;
                    String roundedPound = decimalFormat.format(lb);

                    etPound.setText(roundedPound);
                }
                else if (etKilogram.getText().toString().trim().isEmpty() && !etPound.getText().toString().trim().isEmpty())
                {
                    double poundkiloContant = 1/2.2046226218;
                    DecimalFormat decimalFormat = new DecimalFormat("0.0000");
                    double lb = Double.parseDouble(etPound.getText().toString());
                    double kg = poundkiloContant*lb;
                    String roundedKg = decimalFormat.format(kg);

                    etKilogram.setText(roundedKg);
                }
                else if (!etKilogram.getText().toString().trim().isEmpty() && !etPound.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(massScreen.this, "Value must be entered into only field", Toast.LENGTH_SHORT).show();
                    etPound.setText("");
                    etKilogram.setText("");
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
            etPound.setText("");
            etKilogram.setText("");
            Toast.makeText(this, "All fields cleared", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}