package com.example.valorantapp.data.remote.repositories

import com.example.valorantapp.domain.model.AgentResponse
import com.example.valorantapp.other.Resource

interface ValorantRepository {

    suspend fun getAllAgents(): Resource<AgentResponse>
}