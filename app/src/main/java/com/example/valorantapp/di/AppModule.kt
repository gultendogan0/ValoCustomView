package com.example.valorantapp.di

import com.example.valorantapp.data.remote.ValorantApi
import com.example.valorantapp.other.Constants.BASE_URL
import com.example.valorantapp.repositories.ValorantRepository
import com.example.valorantapp.repositories.ValorantRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideValorantApi(): ValorantApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ValorantApi::class.java)
    }

    @Provides
    @Singleton
    fun provideValorantRepository(repository: ValorantRepositoryImpl): ValorantRepository {
        return repository
    }
}