package com.example.mopus;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MopusRepository {
    private static final String TAG = "MopusRepository";
    FFTCGApi cardApi;

    public MopusRepository() {
        this.cardApi = RetrofitRequest.getInstance().create(FFTCGApi.class);
    }

    public LiveData<List<FFTCGCard>> getCards() {
        final MutableLiveData<List<FFTCGCard>> cardList = new MutableLiveData<>();
        cardApi.getCards().enqueue(new Callback<FFTCGCardList>() {
            @Override
            public void onResponse(Call<FFTCGCardList> call, Response<FFTCGCardList> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                Log.d(TAG, "onResponse: " + response.code());
                if (response.body() != null) {
                    Log.d(TAG, "onResponse: posting new list" + response.body().getCards().size());
                    //Get full object but only pass the list to the views
                    cardList.postValue(response.body().getCards());
                }
            }

            @Override
            public void onFailure(Call<FFTCGCardList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return cardList;
    }
}
