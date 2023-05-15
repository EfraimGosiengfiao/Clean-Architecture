package com.example.data.di

import android.content.SharedPreferences
import com.example.data.ApiService
import com.example.data.common.HttpInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(
        sharedPreferences: SharedPreferences
    ) : OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(HttpInterceptor(sharedPreferences))
            .build()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory() : GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ) : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService{
        retrofit.newBuilder()
        return retrofit.create(ApiService::class.java)
    }
}