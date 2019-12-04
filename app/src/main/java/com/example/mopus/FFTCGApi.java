package com.example.mopus;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface FFTCGApi {
    @GET("get-cards")
    Call<FFTCGCardList> getCards();
}
