package com.example.zadanie_zajecia2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.function.ObjIntConsumer;

public class AbsActivity extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer youTubePlayer;
    private String currentVideoId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.body);
        youTubePlayerView = findViewById(R.id.youtubePlayerViewAbs);
        getLifecycle().addObserver(youTubePlayerView);




        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer2) {
                youTubePlayer = youTubePlayer2;
                youTubePlayer.cueVideo(currentVideoId, 0);
            }
        });


        final Button lowerabsbtnWatchVideo1 = findViewById(R.id.lowerabsbtnWatchVideo1);
        final Button upperabsbtnWatchVideo2 = findViewById(R.id.upperabsbtnWatchVideo2);
        final Button obliquesabsbtnWatchVideo3 = findViewById(R.id.obliquesabsbtnWatchVideo3);

        lowerabsbtnWatchVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="Kd8ZU9NUbRA";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

        upperabsbtnWatchVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="wtEFrO1eFW8";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

        obliquesabsbtnWatchVideo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="Szel63xuAxc";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

    }





}
