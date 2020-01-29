package com.hnineiphyu.retrofitvoting.api

import com.hnineiphyu.retrofitvoting.model.QueenModel
import retrofit2.Call
import retrofit2.http.GET

interface QueenApiInterface{
    @GET("queen")
    fun getQueen(
    ) : Call<List<QueenModel>>
}

