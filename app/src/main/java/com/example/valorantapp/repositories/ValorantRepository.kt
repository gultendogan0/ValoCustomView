package com.example.valorantapp.repositories

import com.example.valorantapp.data.remote.responses.AgentResponse
import com.example.valorantapp.other.Resource


interface ValorantRepository {

    suspend fun getAllAgents(): Resource<AgentResponse>
}