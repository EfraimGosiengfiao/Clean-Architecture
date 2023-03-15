package com.example.data

import com.example.domain.model.InitModel
import com.example.domain.model.ProductsModel
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/http/200")
    suspend fun init() : InitModel

    @GET("/products")
    suspend fun getProducts() : ProductsModel

}