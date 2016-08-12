package com.example.androi.gunsmusicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.gnr_deadhorse);
    }

    public void play(View view) {
        ImageButton playView = (ImageButton) findViewById(R.id.play);

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            playView.setImageResource(R.drawable.ic_av_play_arrow);
        } else {
            mediaPlayer.start();
            playView.setImageResource(R.drawable.ic_av_pause);
        }
    }

    public void rew(View view) {
        if (mediaPlayer.getCurrentPosition() > 1000) {
            mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 1000);
        }
    }

    public void ff(View view) {
        if (mediaPlayer.getCurrentPosition() + 1000 < mediaPlayer.getDuration()) {
            mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 1000);
        }
    }
}
