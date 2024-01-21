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

public class ArmsActivity extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer youTubePlayer;
    private String currentVideoId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arms);
        youTubePlayerView = findViewById(R.id.youtubePlayerView);
        getLifecycle().addObserver(youTubePlayerView);




        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer2) {
                youTubePlayer = youTubePlayer2;
                youTubePlayer.cueVideo(currentVideoId, 0);
            }
        });


        final Button bicepsbtnWatchVideo1 = findViewById(R.id.bicepsbtnWatchVideo1);
        final Button tricepsbtnWatchVideo2 = findViewById(R.id.tricepsbtnWatchVideo2);
        final Button shouldersbtnWatchVideo3 = findViewById(R.id.shouldersbtnWatchVideo3);

        bicepsbtnWatchVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="b0iz-DmOX_M";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

        tricepsbtnWatchVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="R2ReOzVp6qU";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

        shouldersbtnWatchVideo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="7oG08dxIAHs";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

    }





}
