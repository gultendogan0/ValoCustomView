package com.example.valorantapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapp.repositories.ValorantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ValorantViewModel @Inject constructor(
    private val repository: ValorantRepository
) : ViewModel() {

    init {
        getAllAgents()
    }

    fun getAllAgents() {
        viewModelScope.launch {
            val agents = repository.getAllAgents()
            println("agents: ${agents}")
        }
    }
}