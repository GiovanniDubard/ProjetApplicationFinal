package com.example.projetapplicationfinal.presentataion.controller;

import android.content.SharedPreferences;

import com.example.projetapplicationfinal.Constants;
import com.example.projetapplicationfinal.Singletons;
import com.example.projetapplicationfinal.presentataion.model.Characters;
import com.example.projetapplicationfinal.presentataion.model.RestRickAndMortyResponse;
import com.example.projetapplicationfinal.presentataion.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {

    private SharedPreferences sharedPreferences;
    private Gson gson;
    private MainActivity view;

    public MainController(MainActivity mainActivity, Gson gson, SharedPreferences sharedPreferences) {
        this.view = mainActivity;
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;

    }

    public void onStart(){


        List<Characters> charactersList = getDataFromCache();

        if (charactersList != null) {
            view.showList(charactersList);
        } else {
            makeApiCall();
        }
    }

    public void makeApiCall(){
        Call<RestRickAndMortyResponse> call = Singletons.getRickApi().getRickAndMortyResponse();
        call.enqueue(new Callback<RestRickAndMortyResponse>() {
            @Override
            public void onResponse(Call<RestRickAndMortyResponse> call, Response<RestRickAndMortyResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    List<Characters> charactersList = response.body().getResults();
                    saveList(charactersList);
                    view.showList(charactersList);
                } else {
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<RestRickAndMortyResponse> call, Throwable t) {
                view.showError();
            }
        });

    }

    public void saveList(List<Characters> charactersList) {
        String jsonString = gson.toJson(charactersList);
        sharedPreferences
                .edit()
                .putString(Constants.KEY_CHARACTERS_LIST, jsonString  )
                .apply();
    }

    private List<Characters> getDataFromCache() {
        String jsonCharacters = sharedPreferences.getString(Constants.KEY_CHARACTERS_LIST, null);

        if(jsonCharacters == null){
            return null;
        }else {
            Type listType = new TypeToken<List<Characters>>(){}.getType();
            return gson.fromJson(jsonCharacters, listType);
        }
    }

    public void onItemClick(Characters characters){


    }

    public void onButtonAClick(){

    }

    public void onButtonBClick(){

    }
}
