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

public class temperatureScreen extends AppCompatActivity {

    EditText etDegreeCelsius, etFahrenheit, etKelvin;
    Button btnConvertt;

    DecimalFormat decimalFormat = new DecimalFormat("0.0000");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_screen);

        etDegreeCelsius = findViewById(R.id.etDegreeCelsius);
        etFahrenheit = findViewById(R.id.etFahrenheit);
        etKelvin = findViewById(R.id.etKelvin);
        btnConvertt = findViewById(R.id.btnConvertt);

        btnConvertt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etDegreeCelsius.getText().toString().trim().isEmpty() && etFahrenheit.getText().toString().trim().isEmpty() &&
                etKelvin.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(temperatureScreen.this, "Please enter data into one field", Toast.LENGTH_SHORT).show();
                }
                else if (!etDegreeCelsius.getText().toString().trim().isEmpty() && etFahrenheit.getText().toString().trim().isEmpty() &&
                etKelvin.getText().toString().trim().isEmpty())
                {
                    double degCelsius = Double.parseDouble(etDegreeCelsius.getText().toString().trim());
                    double fahrenheit = (degCelsius * 1.8) + 32;
                    String roundedFahrenheit = decimalFormat.format(fahrenheit);

                    etFahrenheit.setText(roundedFahrenheit);

                    double Kelvin = degCelsius + 273.15;
                    String roundedKelvin = decimalFormat.format(Kelvin);

                    etKelvin.setText(roundedKelvin);
                }
                else if (etDegreeCelsius.getText().toString().trim().isEmpty() && !etFahrenheit.getText().toString().trim().isEmpty() &&
                etKelvin.getText().toString().trim().isEmpty())
                {
                    double fahrenheit = Double.parseDouble(etFahrenheit.getText().toString().trim());
                    double degCelsius = (fahrenheit - 32) * 5/9;
                    String roundedDegCelsius = decimalFormat.format(degCelsius);

                    etDegreeCelsius.setText(roundedDegCelsius);

                    double Kelvin = degCelsius + 273.15;
                    String roundedKelvin = decimalFormat.format(Kelvin);

                    etKelvin.setText(roundedKelvin);

                }
                else if (etDegreeCelsius.getText().toString().trim().isEmpty() && etFahrenheit.getText().toString().trim().isEmpty() &&
                        !etKelvin.getText().toString().trim().isEmpty())
                {
                    double Kelvin = Double.parseDouble(etKelvin.getText().toString().trim());
                    double degCelsius = Kelvin - 273.15;
                    String roundedDegCelsius = decimalFormat.format(degCelsius);
                    etDegreeCelsius.setText(roundedDegCelsius);

                    double fahrenheit = degCelsius * 1.8 +32;
                    String roundedFahrenheit = decimalFormat.format(fahrenheit);
                    etFahrenheit.setText(roundedFahrenheit);

                }
                else if (!etDegreeCelsius.getText().toString().trim().isEmpty() && !etFahrenheit.getText().toString().trim().isEmpty() &&
                        !etKelvin.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(temperatureScreen.this, "Value must be entered into only field", Toast.LENGTH_SHORT).show();
                    etDegreeCelsius.setText("");
                    etFahrenheit.setText("");
                    etKelvin.setText("");
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
            etDegreeCelsius.setText("");
            etFahrenheit.setText("");
            etKelvin.setText("");
            Toast.makeText(this, "All fields cleared", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }



}