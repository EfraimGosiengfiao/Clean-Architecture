package com.example.domain.repository

import com.example.domain.model.InitModel

interface InitRepository {
    suspend fun init() : InitModel
}