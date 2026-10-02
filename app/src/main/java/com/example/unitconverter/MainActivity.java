package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editValue;
    Spinner spinnerConversion;
    Button btnConvert;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValue = findViewById(R.id.editValue);
        spinnerConversion = findViewById(R.id.spinnerConversion);
        btnConvert = findViewById(R.id.btnConvert);
        txtResult = findViewById(R.id.txtResult);

        String[] conversions = {
                "Kilometer → Meter",
                "Celsius → Fahrenheit",
                "Kilogram → Gram"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                conversions
        );

        spinnerConversion.setAdapter(adapter);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editValue.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please enter a value",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                double value = Double.parseDouble(
                        editValue.getText().toString()
                );

                int choice = spinnerConversion.getSelectedItemPosition();

                double result;

                if (choice == 0) {
                    result = value * 1000;
                    txtResult.setText(result + " meters");

                } else if (choice == 1) {
                    result = (value * 9 / 5) + 32;
                    txtResult.setText(result + " °F");

                } else {
                    result = value * 1000;
                    txtResult.setText(result + " grams");
                }
            }
        });
    }
}