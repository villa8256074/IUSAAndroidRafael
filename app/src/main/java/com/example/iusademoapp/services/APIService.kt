package com.example.iusademoapp.services

import com.example.iusademoapp.model.request.userDataRequest
import com.example.iusademoapp.model.response.MotoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface APIService {
    @POST("api/findmotos")
    suspend fun postFindUser(@Body requestBody: userDataRequest): Response<MotoResponse>
}