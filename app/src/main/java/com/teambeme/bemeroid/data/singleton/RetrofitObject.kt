package com.teambeme.bemeroid.data.singleton

import com.teambeme.bemeroid.data.api.PeopleService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private const val BASE_URL = "https://reqres.in/"

    val peopleInstance by lazy<PeopleService> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PeopleService::class.java)
    }
}