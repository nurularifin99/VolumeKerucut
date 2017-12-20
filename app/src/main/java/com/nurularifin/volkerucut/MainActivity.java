package com.nurularifin.volkerucut;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity {

    EditText high, radius;
    Button execute;
    TextView result;

    double r, h, coneVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        high = findViewById(R.id.high);
        radius = findViewById(R.id.radius);
        execute = findViewById(R.id.execute);
        result = findViewById(R.id.result);

        execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Volume(r, h);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(radius.getWindowToken(), 0);
            }
        });

    }
    public double Volume (double r, double h)
    {
        if (high.getText().toString().isEmpty()){
            Toast.makeText(this, "Form Tinggi Tidak boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        if (radius.getText().toString().isEmpty()){
            Toast.makeText(this, "Form Jari-Jari Tidak boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        try{
            h = Double.parseDouble(high.getText().toString());
        }catch(Exception e){

        }
        try{
            r = Double.parseDouble(radius.getText().toString());
        }catch(Exception e){

        }
        double coneVolume = 1.0/3.0 * Math.PI * (Math.pow(r,2)) * h;
        DecimalFormat df = new DecimalFormat("#.##");
        result.setText("Volume = "+String.valueOf(df.format(coneVolume)));
        return coneVolume;
    }
}
