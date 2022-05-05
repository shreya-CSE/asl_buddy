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

//---------------------------
        //Testing vocabulary class
        Vocabulary vocab = new Vocabulary();

        ArrayList<String> test = vocab.getVocab();

        if (test.isEmpty())
            System.out.println("Bad");
        else {
            System.out.println("Good!");
            System.out.println(test.get(0));
        }
        //-------------------


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
            translate(input);
        }

    }

    private void translate(String input) {
        //Break string into individual pieces
        String[] words = input.split(" ");

        //Get available words from assets/availableWords.txt
        String availableWords = "";
        try {
            InputStream is = getAssets().open("availableWords.txt");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            availableWords = new String(buffer);
        } catch (IOException e) {
            availableWords = "ERROR";
            e.printStackTrace();
        }

        //Find matching words and add them to list. Mark words not found
        ArrayList<String> found = new ArrayList<String>();
        ArrayList<String> notFound = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            //If available
            if (availableWords.indexOf(words[i]) != -1) {
                //Are there multiple?
                found.add(words[i]);

                int num = 1;
                Boolean multiple = true;

                while (multiple) {
                    String next = words[i] + Integer.toString(num);

                    //If there are multiple
                    if (availableWords.indexOf(next) != -1) {
                        found.add(next);
                        num++;
                    }
                    else {
                        multiple = false;
                    }
                }
            }
            //Mark as not found
            else {
                notFound.add(words[i]);
            }
        }

        if (found.isEmpty()) {
            System.out.println("No matches");
        }
        else {
            for (int i = 0; i < found.size(); i++) {
                System.out.println(found.get(i));
            }
        }

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