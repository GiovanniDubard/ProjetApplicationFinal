package com.example.projetapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://raw.githubusercontent.com/GiovanniDubard/ProjetApplicationFinal/master/";

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeApiCall();
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
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

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

    private void showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();
    }
}


