package com.example.data.repository

import com.example.data.ApiService
import com.example.domain.model.LoginModel
import com.example.domain.param.LoginParam
import com.example.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(
    private val apiService: ApiService
) : LoginRepository {
    override suspend fun login(loginParam: LoginParam): LoginModel {
        return apiService.login(loginParam)
    }
}