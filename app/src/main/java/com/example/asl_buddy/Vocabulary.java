package com.example.asl_buddy;
import java.util.ArrayList;

public class Vocabulary {
    ArrayList<String> vocab;

    public Vocabulary() {
        vocab = new ArrayList<String>();
        vocab.add("Hello World");
    }

    public ArrayList<String> getVocab() {
        return vocab;
    }
}
