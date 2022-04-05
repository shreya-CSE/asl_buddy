package com.example.asl_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class intro_video extends AppCompatActivity {

    VideoView intro_vid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_video);
        intro_vid=findViewById(R.id.videoView);
        MediaController mediaController=new MediaController(this);
        mediaController.setMediaPlayer(intro_vid);
        intro_vid.setMediaController(mediaController);
        intro_vid.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.intoduction));
        intro_vid.start();
    }
}