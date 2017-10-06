package com.example.user.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button calculate;
    private EditText height, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = (Button) findViewById(R.id.cal_button);
        height = (EditText) findViewById(R.id.edit_height);
        weight = (EditText) findViewById(R.id.edit_weight);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mHeight = height.getText().toString();
                String mWeight = weight.getText().toString();

                final double height = Double.valueOf(mHeight);
                final double weight = Double.valueOf(mWeight);

                double bmi = weight / ((height/100)*(height/100));
                String result = String.format("%.2f",bmi);
                String mes = getBmiText(bmi);
                Intent intent = new Intent(MainActivity.this, Page2MainActivity.class);

                intent.putExtra("result",result);
                intent.putExtra("state",mes);

                startActivity(intent);


            }
        });
    }

    private String getBmiText(double bmi){
        String str = "";
        if(bmi < 18.5){
            str = "น้ำหนักน้อยกว่าปกติ";
        }else if(bmi < 25){
            str = "น้ำหนักปกติ";
        }else if(bmi < 30){
            str = "น้ำหนักมากกว่าปกติ (ท้วม)";
        }else{
            str = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }
        return str;
    }
}
