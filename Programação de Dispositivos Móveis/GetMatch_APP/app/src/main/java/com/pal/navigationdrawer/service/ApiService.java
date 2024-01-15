package com.pal.navigationdrawer.service;

import com.pal.navigationdrawer.dto.request.AuthRequest;
import com.pal.navigationdrawer.dto.request.UserRequest;
import com.pal.navigationdrawer.dto.response.CampoResponse;
import com.pal.navigationdrawer.dto.response.JogoResponse;
import com.pal.navigationdrawer.dto.response.UserAuthResponse;
import com.pal.navigationdrawer.dto.response.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("jogo")
    Call<List<JogoResponse>> getAllJogos();

    @GET("campo")
    Call<List<CampoResponse>> getAllCampos();

    @POST("auth/signin")
    Call<UserAuthResponse> authenticate(@Body AuthRequest authRequest);

    @POST("users")
    Call<UserResponse> saveUser(@Body UserRequest userRequest);

}
