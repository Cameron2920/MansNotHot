package com.cam.cam.takeoffyourjacketpls;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.likesdogscam.ericmonkman.ericmonkmansoundboard.activities.SoundboardActivity;

public class MansNotHotActivity extends SoundboardActivity {
  private static String SOUND_CLIP_DESCRIPTION_PATH = "mans_not_hot.csv";
  private static String SOUND_CLIP_DIRECTORY = "audio_clips";

  private ImageView   roadmanShaqImageView;
  private ImageView   playButtonImageView;
  private MediaPlayer layDownAFatBeatMediaPlayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getSupportActionBar().hide();
    setContentView(R.layout.activity_mans_not_hot);
    roadmanShaqImageView = (ImageView) findViewById(R.id.roadmanShaqImageView);
    playButtonImageView = (ImageView) findViewById(R.id.playButtonImageView);
    RecyclerView soundClipRecyclerView = (RecyclerView) findViewById(R.id.soundClipRecyclerView);
    final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    soundClipRecyclerView.setLayoutManager(layoutManager);
    soundClipRecyclerView.setHasFixedSize(true);
    soundClipRecyclerView.setNestedScrollingEnabled(false);
    soundClipRecyclerView.setFocusable(false);
    initialize(soundClipRecyclerView, SOUND_CLIP_DESCRIPTION_PATH, SOUND_CLIP_DIRECTORY, R.layout.cell_sound_clip);
    layDownAFatBeatMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fat_beat);
    layDownAFatBeatMediaPlayer.setLooping(true);
    roadmanShaqImageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        toggleLayDownAFatBeatMediaPlayer();
      }
    });
  }

  private void toggleLayDownAFatBeatMediaPlayer(){
    if(layDownAFatBeatMediaPlayer.isPlaying()){
      layDownAFatBeatMediaPlayer.pause();
      playButtonImageView.setImageDrawable(ContextCompat.getDrawable(this, android.R.drawable.ic_media_play));
    }
    else{
      layDownAFatBeatMediaPlayer.start();
      playButtonImageView.setImageDrawable(ContextCompat.getDrawable(this, android.R.drawable.ic_media_pause));
    }
  }

}
