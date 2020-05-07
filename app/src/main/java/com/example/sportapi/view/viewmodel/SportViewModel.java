package com.example.sportapi.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sportapi.model.sport.ResultItem;
import com.example.sportapi.model.sport.SportTeamResponse;
import com.example.sportapi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<ResultItem>> listDiscoverSport = new MutableLiveData<>();

    public void setSportDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }
        apiMain.getApiSport().getSportTeam().enqueue(new Callback<SportTeamResponse>() {
            @Override
            public void onResponse(Call<SportTeamResponse> call, Response<SportTeamResponse> response) {
                SportTeamResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getResult() != null){
                    ArrayList<ResultItem> sportDiscoverItems = responseDiscover.getResult();
                    listDiscoverSport.postValue(sportDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<SportTeamResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<ResultItem>> getSportDiscover(){
        return listDiscoverSport;
    }
}
