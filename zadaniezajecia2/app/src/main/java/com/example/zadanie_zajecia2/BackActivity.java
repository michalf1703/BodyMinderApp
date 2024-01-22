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

public class BackActivity extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer youTubePlayer;
    private String currentVideoId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back);
        youTubePlayerView = findViewById(R.id.youtubePlayerViewBack);
        getLifecycle().addObserver(youTubePlayerView);




        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer2) {
                youTubePlayer = youTubePlayer2;
                youTubePlayer.cueVideo(currentVideoId, 0);
            }
        });


        final Button latsbackbtnWatchVideo1 = findViewById(R.id.latsbackbtnWatchVideo1);
        final Button trapsbackbtnWatchVideo2 = findViewById(R.id.trapsbackbtnWatchVideo2);


        latsbackbtnWatchVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="O94yEoGXtBY";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

        trapsbackbtnWatchVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="kmGapunUkqQ";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

    }





}
