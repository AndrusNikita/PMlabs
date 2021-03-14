package com.example.pmlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Lab1onClick(View v) {
        Intent lab1go = new Intent(".Lab1");
        startActivity(lab1go);
    }

    public void Lab2onClick(View v) {
        Intent lab2go = new Intent(".Lab2");
        startActivity(lab2go);
    }

    public void Lab3onClick(View v) {
        Intent lab3go = new Intent(".Lab3");
        startActivity(lab3go);
    }


}