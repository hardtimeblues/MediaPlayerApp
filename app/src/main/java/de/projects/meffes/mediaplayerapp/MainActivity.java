package de.projects.meffes.mediaplayerapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer myPlayer;
    private float leftVolume;
    private float rightVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPlayer = MediaPlayer.create(this, R.raw.phrase_where_are_you_going);
        leftVolume = 4;
        rightVolume = 4;
        myPlayer.setVolume(leftVolume, rightVolume);


        Button buttonPlay = (Button) findViewById(R.id.button_play);
        Button buttonPause = (Button) findViewById(R.id.button_pause);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPlayer.start();


                myPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast fToast = Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_LONG);
                        fToast.show();
                    }
                });

            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPlayer.pause();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    public void plusVolume(View view) {
        leftVolume++;
        rightVolume++;
        myPlayer.setVolume(leftVolume, rightVolume);
    }

    public void minusVolume(View view) {
        leftVolume--;
        rightVolume--;
        myPlayer.setVolume(leftVolume, rightVolume);

    }
}
