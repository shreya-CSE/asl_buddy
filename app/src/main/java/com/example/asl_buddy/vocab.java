package com.example.asl_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class vocab extends AppCompatActivity {

    private CheckBox intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab);

        intro=findViewById(R.id.checkBox);
        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intro_intent=new Intent(getApplicationContext(),intro_video.class);
                startActivity(intro_intent);
            }
        });

    }
}