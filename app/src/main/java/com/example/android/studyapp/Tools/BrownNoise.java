package com.example.android.studyapp.Tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.studyapp.MainActivity;
import com.example.android.studyapp.R;

public class BrownNoise extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brown_noise);

        mediaPlayer = MediaPlayer.create(this, R.raw.brownaudio);

        Button playButton = (Button) findViewById(R.id.btnPlay);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(BrownNoise.this, "The noice is over, press play again", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button pauseButton = (Button) findViewById(R.id.btnPause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
    }
    public void backClick (View view) {
        Intent i = new Intent(this, ToolsMenu.class);
        startActivity (i);
    }
}

