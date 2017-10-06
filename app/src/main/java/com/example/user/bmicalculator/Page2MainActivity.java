package com.example.user.bmicalculator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Page2MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);


        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("result");
        String message = bundle.getString("state");

        TextView textData = (TextView) findViewById(R.id.textView2_result);
        textData.setText("ค่า BMI ที่ได้คือ "+text+"\n\nอยู่ในเกณฑ์ : "+message);

        Button button = (Button)findViewById(R.id.button_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page2MainActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(Page2MainActivity.this,"มาคำนวณอีกรอบเถอะ!",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
