package com.example.asl_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class home_page extends AppCompatActivity {
    //Added by Gabriel
    // Test - Shreya
    private ImageButton vocabu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        vocabu=findViewById(R.id.imageButton);
        vocabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vocabu_intent=new Intent(getApplicationContext(),vocab.class);
                startActivity(vocabu_intent);
            }
        });

    }
}