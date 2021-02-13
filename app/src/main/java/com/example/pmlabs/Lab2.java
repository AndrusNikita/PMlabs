package com.example.pmlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.abs;
import static java.lang.Math.atan;
import static java.lang.Math.pow;

public class Lab2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
    }

    public void onButtonClick (View v){
        EditText X = (EditText)findViewById(R.id.Xenter);
        TextView res = (TextView) findViewById(R.id.ResultText);

        int x = Integer.parseInt(X.getText().toString());
        int e = 5;
        int a = 4;
        int c = 8;
        double Res = (Math.sqrt((pow(e,x))-pow(Math.cos(pow(x,2) * pow(a,5)),4))+pow(atan(a-pow(x,5)),4)) / pow(abs(a+(x*pow(c,4))),-e);
        res.setText(Double.toString(Res));

    }
}