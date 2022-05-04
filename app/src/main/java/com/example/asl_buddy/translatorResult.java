package com.example.asl_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class translatorResult extends AppCompatActivity {

    private String engText;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator_result);

        engText = (String) getIntent().getStringExtra("data");
        Toast.makeText(getApplicationContext(),engText,Toast.LENGTH_SHORT).show();

        //-------------------
        //... process input data
        engText = engText.toLowerCase(Locale.ROOT);

        //Remove punctuation (,.!?)
        String input = new String("");
        for (int i = 0; i < engText.length(); i++) {
            char ch = engText.charAt(i);
            if (ch != '.' && ch != ',' && ch != '!' && ch != '?')
                input += ch;
        }

        //Break string into individual words
        String[] words = input.split(" ");

        //Search for words in drawable folder...
        //for (int i = 0; i < words.length; i++)

        //------------------




        layout = (LinearLayout) findViewById(R.id.scrollLayout);
        //ImageButton btn = new ImageButton(this);
        //btn.setImageResource(R.drawable.hello123);

        //layout.addView(btn);
    }
}