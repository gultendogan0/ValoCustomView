package com.example.valorantapp.data.remote

import com.example.valorantapp.data.remote.responses.AgentResponse
import retrofit2.Response
import retrofit2.http.GET

interface ValorantApi {

    @GET("v1/agents")
    suspend fun getAllAgents() : Response<AgentResponse>
}