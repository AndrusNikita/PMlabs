package com.example.pmlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.abs;
import static java.lang.Math.atan;
import static java.lang.Math.pow;

public class Lab3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);
        TextView res = (TextView) findViewById(R.id.FileText);
        res.setMovementMethod(new ScrollingMovementMethod());
    }

    public void onButtonClick (View v){

        EditText X = (EditText)findViewById(R.id.xenter1);
        EditText step = (EditText)findViewById(R.id.stepenter);
        EditText curCount = (EditText)findViewById(R.id.countEnt);
        //TextView res = (TextView) findViewById(R.id.ResultText);

        double x = Double.parseDouble(X.getText().toString());
        int count = Integer.parseInt(curCount.getText().toString());
        double Step = Double.parseDouble(step.getText().toString());
        int e = 5;
        int a = 4;
        int c = 8;
        double Res;
        String textRes = "";
        String textlab4 = "";

        try {
            FileOutputStream fileOutput = openFileOutput("Lab3text.txt", MODE_PRIVATE);
            FileOutputStream fileOutput4 = openFileOutput("Lab4text.txt", MODE_PRIVATE);

            String stepStr = "Step = "+Step;
            String countStr = "\nThe number of cycles = "+count;

            fileOutput.write(stepStr.getBytes());
            fileOutput.write(countStr.getBytes());

            do {
                Res = (Math.sqrt((pow(e, x)) - pow(Math.cos(pow(x, 2) * pow(a, 5)), 4)) + pow(atan(a - pow(x, 5)), 4)) / pow(abs(a + (x * pow(c, 4))), -e);
                @SuppressLint("DefaultLocale") String res_string = String.format("%.2f", Res);
                textRes = textRes+"\n----------------------------------------------------------------------------------------\nX = "+x+";\nRes = "+res_string;
                textlab4 = textlab4+x+" "+res_string+"\n";

                x = x + Step;
            } while (x<=count);

            fileOutput.write(textRes.getBytes());
            fileOutput.close();
            fileOutput4.write(textlab4.getBytes());
            fileOutput4.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void onLoadClick (View v){

        TextView res = (TextView) findViewById(R.id.FileText);

        try {
            FileInputStream fileInput = openFileInput("Lab3text.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuilder strBuffer =  new StringBuilder();
            String ResLines;
            while ((ResLines = buffer.readLine()) != null) {
                strBuffer.append(ResLines).append("\n");
            }
            res.setText(strBuffer.toString());
            fileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}