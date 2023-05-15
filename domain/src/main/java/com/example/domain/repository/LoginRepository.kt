package com.example.domain.repository

import com.example.domain.model.LoginModel
import com.example.domain.param.LoginParam

interface LoginRepository {
    suspend fun login(loginParam: LoginParam) : LoginModel
}