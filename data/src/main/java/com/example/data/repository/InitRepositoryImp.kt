package com.example.data.repository

import com.example.data.ApiService
import com.example.domain.common.NetworkResult
import com.example.domain.model.InitModel
import com.example.domain.repository.InitRepository
import javax.inject.Inject

class InitRepositoryImp @Inject constructor(private val apiService: ApiService) : InitRepository {
    override suspend fun init(): InitModel {
        return apiService.init()
    }
}