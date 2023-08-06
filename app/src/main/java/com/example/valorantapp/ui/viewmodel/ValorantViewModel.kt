package com.example.valorantapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapp.domain.model.Agent
import com.example.valorantapp.domain.model.AgentResponse
import com.example.valorantapp.domain.usecase.GetAllAgentsUseCase
import com.example.valorantapp.other.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ValorantViewModel @Inject constructor(private val getAllAgentsUseCase: GetAllAgentsUseCase) : ViewModel() {

    private val _agentsState = MutableLiveData<Resource<AgentResponse>>()
    val agentsState: LiveData<Resource<AgentResponse>> get() = _agentsState

    fun getAllAgents() {
        viewModelScope.launch {
            _agentsState.value = Resource.loading(null)
            val response = getAllAgentsUseCase()
            _agentsState.value = response

        }
    }

    fun getDuelistAgents(): List<Agent> {
        val response = agentsState.value?.data
        return response?.data?.filter { it.role?.displayName == "Duelist" } ?: emptyList()
    }

    fun getControllerAgents(): List<Agent> {
        val response = agentsState.value?.data
        return response?.data?.filter { it.role?.displayName == "Controller" } ?: emptyList()
    }

    fun getInitiatorAgents(): List<Agent> {
        val response = agentsState.value?.data
        return response?.data?.filter { it.role?.displayName == "Initiator" } ?: emptyList()
    }

    fun getSentinelAgents(): List<Agent> {
        val response = agentsState.value?.data
        return response?.data?.filter { it.role?.displayName == "Sentinel" } ?: emptyList()
    }
}