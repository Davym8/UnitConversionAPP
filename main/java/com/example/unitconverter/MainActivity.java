package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private void convertkilos()
    {

        String value_entered = numdec.getText().toString();
        if (value_entered.equals(""))
        {
            Toast.makeText(MainActivity.this, "Please enter a number.", Toast.LENGTH_SHORT).show();
            return;
        }
        double kilo = Double.parseDouble(value_entered);
        double pounds = kilo * 2.205;
        double convertpounds = Math.round(pounds*100);
        double result = convertpounds/100;
        String ans = String.valueOf(result);
        result1.setText(ans);
        measurement.setText("Pounds (lb)");


        double grams = (kilo * 1000);
        double convertgrams = Math.round(grams * 100);
        double gramresult = convertgrams/100;
        String ans2 = String.valueOf(gramresult);
        result2.setText(ans2);
        measurement2.setText("Grams");

        double ounces = kilo*35.274;
        double convertounces = Math.round(ounces * 100);
        double ounceresult = convertounces/100;
        String ans3 = String.valueOf(ounceresult);
        result3.setText(ans3);
        measurement3.setText("Ounces (Oz)");

    }

    private void convertmetre()
    {
        String value_entered = numdec.getText().toString();
        if (value_entered.equals(""))
        {
            Toast.makeText(MainActivity.this, "Please enter a number.", Toast.LENGTH_SHORT).show();
            return;
        }
        double metre = Double.parseDouble(value_entered);
        double cm = metre * 100;
        double convertcm = Math.round(cm*100);
        double result = convertcm/100;
        String ans = String.valueOf(result);
        result1.setText(ans);
        measurement.setText("Centimetres (CM)");


        double foot = metre / 0.3048;
        double convertfoot = Math.round(foot*100);
        double footresult = convertfoot/100;
        String ans2 = String.valueOf(footresult);
        result2.setText(ans2);
        measurement2.setText("Feet (ft)");

        double inches = metre * 39.3701;
        double convertinch = Math.round(inches*100);
        double inchresult = convertinch/100;
        String ans3 = String.valueOf(inchresult);
        result3.setText(ans3);
        measurement3.setText("Inches (In'')");
    }
    private void convertcelsius()
    {
        String value_entered = numdec.getText().toString();
        if (value_entered.equals(""))
        {
            Toast.makeText(MainActivity.this, "Please enter a number.", Toast.LENGTH_SHORT).show();
            return;
        }
        double celsius = Double.parseDouble(value_entered);
        double fahrenheit = ((celsius*9)/5)+32;
        double convertfh = Math.round(fahrenheit*100);
        double result = convertfh / 100;
        String ans = String.valueOf(result);
        result1.setText(ans);
        measurement.setText("Fahrenheit");

        double kelvin = celsius + 273.15;
        double convertkelvin = Math.round(kelvin * 100);
        double kelvinresult = convertkelvin / 100;
        String ans2 = String.valueOf(kelvinresult);
        result2.setText(ans2);
        measurement2.setText("Kelvin");
    }

    EditText numdec;
    ImageButton tempbutton, kgbutton, lengthbutton;
    TextView result1, result2, result3;
    TextView measurement, measurement2, measurement3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Units, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);




        numdec = findViewById(R.id.numdec);
        tempbutton = findViewById(R.id.tempbutton);
        kgbutton = findViewById(R.id.kgbutton);
        lengthbutton = findViewById(R.id.lengthbutton);

        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);
        result3 = findViewById(R.id.result3);

        measurement = findViewById(R.id.measurement);
        measurement2 = findViewById(R.id.measurement2);
        measurement3 = findViewById(R.id.measurement3);

        result1.setVisibility(View.INVISIBLE);
        result2.setVisibility(View.INVISIBLE);
        result3.setVisibility(View.INVISIBLE);

        measurement.setVisibility(View.INVISIBLE);
        measurement2.setVisibility(View.INVISIBLE);
        measurement3.setVisibility(View.INVISIBLE);


        tempbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String contype = spinner.getSelectedItem().toString();
                if (contype.equals("Celsius"))
                {
                    convertcelsius();
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.INVISIBLE);

                    measurement.setVisibility(View.VISIBLE);
                    measurement2.setVisibility(View.VISIBLE);
                    measurement3.setVisibility(View.INVISIBLE);
                }else {
                    Toast.makeText(MainActivity.this,
                            "Please Choose correct conversion.", Toast.LENGTH_SHORT).show();
                }


            }
        });

        kgbutton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String contype = spinner.getSelectedItem().toString();
                if (contype.equals("Kilograms"))
                {
                    convertkilos();
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);

                    measurement.setVisibility(View.VISIBLE);
                    measurement2.setVisibility(View.VISIBLE);
                    measurement3.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(MainActivity.this,
                            "Please Choose correct conversion.", Toast.LENGTH_SHORT).show();
                }


            }
        });


        lengthbutton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String contype = spinner.getSelectedItem().toString();
                if (contype.equals("Metre"))
                {
                    convertmetre();
                    result1.setVisibility(View.VISIBLE);
                    result2.setVisibility(View.VISIBLE);
                    result3.setVisibility(View.VISIBLE);

                    measurement.setVisibility(View.VISIBLE);
                    measurement2.setVisibility(View.VISIBLE);
                    measurement3.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(MainActivity.this,
                            "Please Choose correct conversion.", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }


}