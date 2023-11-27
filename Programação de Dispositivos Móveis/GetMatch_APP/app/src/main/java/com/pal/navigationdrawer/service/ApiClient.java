package com.pal.navigationdrawer.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public final ApiService api;
    private final String baseUrl = "http://:8080";

    public ApiClient ()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl + "/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiService.class);
    }
}
