package com.example.data

import com.example.domain.model.InitModel
import com.example.domain.model.LoginModel
import com.example.domain.model.ProductsModel
import com.example.domain.param.LoginParam
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/http/200")
    suspend fun init() : InitModel

    @POST("/auth/login")
    suspend fun login(@Body loginParam: LoginParam) : LoginModel

    @GET("auth/products")
    suspend fun getProducts() : ProductsModel

}