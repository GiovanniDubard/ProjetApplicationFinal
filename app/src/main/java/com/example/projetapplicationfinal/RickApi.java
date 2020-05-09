package com.example.projetapplicationfinal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RickApi {
    @GET("RickAndMortyAPI.json")
    Call<RestRickAndMortyResponse> getRickAndMortyResponse();

}
