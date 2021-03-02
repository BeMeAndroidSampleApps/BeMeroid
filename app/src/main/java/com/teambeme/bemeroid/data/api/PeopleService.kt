package com.teambeme.bemeroid.data.api

import com.teambeme.bemeroid.model.ResponsePeople
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PeopleService {
    @GET("api/users")
    fun getPeople(
        @Path("page") page: Int
    ): Call<ResponsePeople>
}