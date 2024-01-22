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

public class ChestActivity extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer youTubePlayer;
    private String currentVideoId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chest);
        youTubePlayerView = findViewById(R.id.youtubePlayerViewChest);
        getLifecycle().addObserver(youTubePlayerView);




        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer2) {
                youTubePlayer = youTubePlayer2;
                youTubePlayer.cueVideo(currentVideoId, 0);
            }
        });


        final Button lowerbtnWatchVideo1 = findViewById(R.id.lowerchestbtnWatchVideo1);
        final Button middlebtnWatchVideo2 = findViewById(R.id.middlechestbtnWatchVideo2);
        final Button upperbtnWatchVideo3 = findViewById(R.id.upperchestbtnWatchVideo3);

        lowerbtnWatchVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="E7ZuFDpIBL8";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

       middlebtnWatchVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="8zUEUBRd6b0";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

        upperbtnWatchVideo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoId="YqFfh5IZUBs";
                youTubePlayer.cueVideo(currentVideoId,0);
            }
        });

    }





}
