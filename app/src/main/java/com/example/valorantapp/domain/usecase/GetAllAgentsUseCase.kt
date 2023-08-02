package com.example.valorantapp.domain.usecase


import com.example.valorantapp.data.remote.repositories.ValorantRepository
import com.example.valorantapp.domain.model.AgentResponse
import com.example.valorantapp.other.Resource

class GetAllAgentsUseCase(private val repository: ValorantRepository) {
    suspend operator fun invoke(): Resource<AgentResponse> {
        return repository.getAllAgents()
    }
}