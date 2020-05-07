package com.example.sportapi.service;

import com.example.sportapi.model.sport.SportTeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SportRepository {
    @GET("api/football/?&met=Teams&teamId=2616&APIkey=7b40e323193e1c9c380c2eccbf550103e24c933210839de38c884c7c018de384")
    Call<SportTeamResponse> getSportTeam();
}
