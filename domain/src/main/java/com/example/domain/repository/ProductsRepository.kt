package com.example.domain.repository

import com.example.domain.model.ProductsModel

interface ProductsRepository {
    suspend fun getProducts() : ProductsModel
}