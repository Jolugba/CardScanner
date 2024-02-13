package com.example.cardscanner.network

import com.example.cardscanner.network.models.CardDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CardService {
    @GET("{number}")
    fun getCard(@Path("number")number: Int) : Call<CardDetail>
}