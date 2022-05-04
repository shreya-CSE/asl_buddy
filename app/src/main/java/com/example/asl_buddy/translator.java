package com.example.asl_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Toast;

public class translator extends AppCompatActivity {

    private Button useText;
    private EditText textInput;
    private ImageButton useVoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        textInput = findViewById(R.id.inputText);

        //Use text option
        useText = findViewById(R.id.goButton);
        useText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = textInput.getText().toString().trim();

                //Display results in new activity
                Intent result = new Intent(getApplicationContext(), translatorResult.class);
                result.putExtra("data", text); //Pass data to new activity
                startActivity(result);
            }
        });

        //Use speech to text
        useVoice = findViewById(R.id.micButton);
        useVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ADD SPEECH TO TEXT HERE
                // MAKE VARIABLE TO STORE
                // PASS USING "intent.putExtra("data", val);"

                Toast.makeText(getApplicationContext(),"You usin you voice",Toast.LENGTH_SHORT).show();
            }
        });
    }
}