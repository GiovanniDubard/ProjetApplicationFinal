package com.example.projetapplicationfinal;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.projetapplicationfinal.data.RickApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singletons {
    private static Gson gsonInstance;
    private static RickApi rickApiInstance;
    private static SharedPreferences sharedPreferences;

    public static Gson getGson(){
        if(gsonInstance == null){
            gsonInstance = new GsonBuilder()
                                .setLenient()
                                .create();
        }
        return gsonInstance;
    }

    public static RickApi getRickApi() {
        if(rickApiInstance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();

            rickApiInstance = retrofit.create(RickApi.class);
        }
        return rickApiInstance;
    }

    public static SharedPreferences getSharedPreferences(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("application_rickandmorty", Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

}
