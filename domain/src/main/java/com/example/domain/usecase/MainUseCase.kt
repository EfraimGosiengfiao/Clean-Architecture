package com.example.domain.usecase

import android.util.Log
import com.example.domain.common.NetworkResult
import com.example.domain.model.InitModel
import com.example.domain.model.ProductsModel
import com.example.domain.repository.InitRepository
import com.example.domain.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val initRepository: InitRepository,
    private val productsRepository: ProductsRepository
){
    fun init() : Flow<NetworkResult<InitModel>> = flow {
        try {
            val response = initRepository.init()
            emit(NetworkResult.OnSuccess(response))
        }catch (e : Exception){
            emit(NetworkResult.OnError(e.message.toString()))
            Log.d( "ApiCall: ", "${e.message}")
        }
    }.flowOn(Dispatchers.IO)

    fun getProducts() : Flow<NetworkResult<ProductsModel>> = flow {
        try {
            val response = productsRepository.getProducts()
            Log.d( "ApiCall: ", "${response}")
            emit(NetworkResult.OnSuccess(response))
        }catch (e : Exception){
            emit(NetworkResult.OnError(e.message.toString()))
            Log.d( "ApiCall: ", "${e.message}")
        }
    }

}