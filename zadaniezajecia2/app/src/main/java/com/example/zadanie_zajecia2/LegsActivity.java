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

public class LegsActivity extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer youTubePlayer;
    private String currentVideoId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legs);
        youTubePlayerView = findViewById(R.id.youtubePlayerViewLegs);
        getLifecycle().addObserver(youTubePlayerView);




        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer2) {
                youTubePlayer = youTubePlayer2;
                youTubePlayer.cueVideo(currentVideoId, 0);
            }
        });


        final Button quadslegsbtnWatchVideo1 = findViewById(R.id.quadslegsbtnWatchVideo1);
        final Button hamstringslegsbtnWatchVideo2 = findViewById(R.id.hamstringslegsbtnWatchVideo2);
        final Button calveslegsbtnWatchVideo3 = findViewById(R.id.calveslegsbtnWatchVideo3);

       quadslegsbtnWatchVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="Ud9hEOxJMpQ";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

        hamstringslegsbtnWatchVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="1jp2uhfO8M0";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

        calveslegsbtnWatchVideo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="FSPqzLv2HU4";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

    }





}
