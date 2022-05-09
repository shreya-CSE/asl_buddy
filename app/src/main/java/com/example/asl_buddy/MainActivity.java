package com.example.asl_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button login_button;
    Button sign_up_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        login_button = findViewById(R.id.button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent login_intent=new Intent(getApplicationContext(),login_page.class);
                startActivity(login_intent);
            }
        }
        );

        sign_up_button = findViewById(R.id.button2);
        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent sign_up_intent=new Intent(getApplicationContext(),sign_up.class);
                startActivity(sign_up_intent);
            }
        }

        );
    }
}