package com.example.asl_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.ArrayList;

public class translatorResult extends AppCompatActivity {

    private String engText;
    private LinearLayout layoutY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator_result);

        engText = (String) getIntent().getStringExtra("data");

        //Convert to lowercase
        engText = engText.toLowerCase(Locale.ROOT);

        //Remove punctuation (,.!?)
        String input = new String("");
        for (int i = 0; i < engText.length(); i++) {
            char ch = engText.charAt(i);
            if (ch != '.' && ch != ',' && ch != '!' && ch != '?')
                input += ch;
        }

        //Make sure input isn't empty or whitespaces
        if (input == null || input.length() == 0 || input.trim().isEmpty()) {
            System.out.println("No input");
        }
        else {
            //Access vocab class
            Vocabulary vocab = new Vocabulary(this);
            //Lookup vocab entries
            ArrayList<String> found = vocab.lookup(input);

            //If input doesn't match ANY vocabulary entries
            if (found.isEmpty()) {
                //Inform that there wasn't anything found
            }
            //Pass available words to be displayed
            else {
                for (int i = 0; i < found.size(); i++) {
                    System.out.println("Found: " + found.get(i));
                }
                //displayResults(found, original sentence)
            }
        }

    }

    private void displayResults(String input) {


        layoutY = findViewById(R.id.yLayout);

        /*
        for (int i = 0; i < 5; i++) {
            HorizontalScrollView scrollX = new HorizontalScrollView(this);

            LinearLayout layoutX = new LinearLayout(this);
            layoutX.setOrientation(LinearLayout.HORIZONTAL);

            scrollX.addView(layoutX);

            for (int k = 0; k < 1; k++) {
                ImageButton button = new ImageButton(this);
                button.setImageResource(R.drawable.hello123);

                layoutX.addView(button);
            }

            layoutY.addView(scrollX);
        }
        */


        // HOW TO vvv------------
        //ImageButton btn = new ImageButton(this);
        //btn.setImageResource(R.drawable.hello123);
        //layout.addView(btn);
        // HOW TO ^^^------------
    }
}