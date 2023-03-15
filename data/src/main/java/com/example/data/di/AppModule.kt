package com.example.data.di

import com.example.data.ApiService
import com.example.data.repository.InitRepositoryImp
import com.example.data.repository.ProductsRepositoryImp
import com.example.domain.repository.InitRepository
import com.example.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun providesInitRepository(retrofitService : ApiService) : InitRepository{
        return InitRepositoryImp(retrofitService)
    }

    @Provides
    @Singleton
    fun providesProductsRepository(retrofitService: ApiService) : ProductsRepository{
        return ProductsRepositoryImp(retrofitService)
    }
}