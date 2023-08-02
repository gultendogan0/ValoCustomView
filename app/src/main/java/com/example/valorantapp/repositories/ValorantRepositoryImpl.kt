package com.example.valorantapp.repositories

import android.util.Log
import com.example.valorantapp.other.Resource
import com.example.valorantapp.data.remote.ValorantApi
import com.example.valorantapp.data.remote.responses.AgentResponse
import javax.inject.Inject

class ValorantRepositoryImpl @Inject constructor(
    private val valorantApi: ValorantApi
) : ValorantRepository {

    override suspend fun getAllAgents(): Resource<AgentResponse> {
        return try{
            val response = valorantApi.getAllAgents()
            if(response.isSuccessful) {
                response.body()?.let{
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occured", null)
            }else{
                Resource.error("An unknown error occured", null)
            }
        }catch (e: Exception){
            Log.e("EXCEPTION", "EXCEPTION:", e)
            Resource.error("Couldn't reach the server. Check your internet connection", null)
        }
    }


}