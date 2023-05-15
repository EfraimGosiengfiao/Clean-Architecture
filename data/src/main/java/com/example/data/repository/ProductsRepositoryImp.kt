package com.example.data.repository

import com.example.data.ApiService
import com.example.domain.model.ProductsModel
import com.example.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImp @Inject constructor(private val apiService: ApiService) : ProductsRepository{
    override suspend fun getProducts(): ProductsModel {
        return apiService.getProducts()
    }
}