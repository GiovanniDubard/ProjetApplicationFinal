package com.example.projetapplicationfinal.data;

import com.example.projetapplicationfinal.presentataion.model.RestRickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RickApi {
    @GET("RickAndMortyAPI.json")
    Call<RestRickAndMortyResponse> getRickAndMortyResponse();

}
