package com.example.projetapplicationfinal.presentataion.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import com.example.projetapplicationfinal.R;
import com.example.projetapplicationfinal.data.RickApi;
import com.example.projetapplicationfinal.presentataion.model.Characters;
import com.example.projetapplicationfinal.presentataion.model.RestRickAndMortyResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    private static final String BASE_URL = "https://raw.githubusercontent.com/GiovanniDubard/ProjetApplicationFinal/master/";

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("application_rickandmorty", Context.MODE_PRIVATE);
        gson = new GsonBuilder()
                .setLenient()
                .create();

        List<Characters> charactersList = getDataFromCache();

        if (charactersList != null) {
            showList(charactersList);
        } else {
            makeApiCall();
        }

    }


    private List<Characters> getDataFromCache() {
        String jsonCharacters = sharedPreferences.getString("jsonCharactersList", null);

        if(jsonCharacters == null){
            return null;
        }else {
            Type listType = new TypeToken<List<Characters>>(){}.getType();
            return gson.fromJson(jsonCharacters, listType);
        }
    }

    private void showList(List<Characters> charactersList){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new ListAdapter(charactersList);
        recyclerView.setAdapter(mAdapter);

    }


    private void makeApiCall(){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            final RickApi rickApi = retrofit.create(RickApi.class);

            Call<RestRickAndMortyResponse> call = rickApi.getRickAndMortyResponse();
            call.enqueue(new Callback<RestRickAndMortyResponse>() {
                @Override
                public void onResponse(Call<RestRickAndMortyResponse> call, Response<RestRickAndMortyResponse> response) {
                    if(response.isSuccessful() && response.body() != null){
                            List<Characters> charactersList = response.body().getResults();
                            saveList(charactersList);
                            showList(charactersList);
                    } else {
                        showError();
                    }
                }

                @Override
                public void onFailure(Call<RestRickAndMortyResponse> call, Throwable t) {
                    showError();
                }
            });

        }

    private void saveList(List<Characters> charactersList) {
        String jsonString = gson.toJson(charactersList);
        sharedPreferences
                .edit()
                .putString("jsonCharactersList", jsonString  )
                .apply();

        Toast.makeText(getApplicationContext(), "List saved", Toast.LENGTH_SHORT).show();
    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();
    }
}


