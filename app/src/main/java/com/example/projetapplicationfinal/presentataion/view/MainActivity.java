package com.example.projetapplicationfinal.presentataion.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projetapplicationfinal.R;
import com.example.projetapplicationfinal.Singletons;
import com.example.projetapplicationfinal.presentataion.controller.MainController;
import com.example.projetapplicationfinal.presentataion.model.Characters;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MediaPlayer mediaPlayer;
    private MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.ricktheme);
        controller = new MainController(
                this,
                Singletons.getGson(),
                Singletons.getSharedPreferences(getApplicationContext())
        );
        controller.onStart();

    }

    public void playSound(View view){
    mediaPlayer.start();
    }

    public void stopSound(View view){
        mediaPlayer.stop();
    }

    public void showList(List<Characters> charactersList){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new ListAdapter(charactersList, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Characters item) {
                controller.onItemClick(item);
            }
        });
        recyclerView.setAdapter(mAdapter);

    }


    public void showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();
    }

    public void navigateToDetails(Characters characters) {
        Toast.makeText(getApplicationContext(), "TODO Navigate", Toast.LENGTH_SHORT).show();
    }
}


