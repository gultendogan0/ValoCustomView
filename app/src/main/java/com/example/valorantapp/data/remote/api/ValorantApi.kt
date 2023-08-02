package com.example.valorantapp.data.remote.api

import com.example.valorantapp.domain.model.AgentResponse
import retrofit2.Response
import retrofit2.http.GET

interface ValorantApi {

    @GET("v1/agents")
    suspend fun getAllAgents() : Response<AgentResponse>
}