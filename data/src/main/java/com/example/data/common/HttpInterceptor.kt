package com.example.data.common

import android.content.SharedPreferences
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.nio.charset.Charset

class HttpInterceptor(
    private val sharedPreferences: SharedPreferences
    ) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val token = sharedPreferences.getString("token","")
        val request = chain.request().newBuilder()
            .header("Authorization", "$token")
            .header("Content-Type", "application/json;charset=UTF-8")
            .build()

        val response = chain.proceed(request)
        Log.d( "InterceptorResponse: ",
            "Endpoint: ${request.url} \nCode: ${response.code} \nResponse: ${response.peekBody(2048).string()}")

        if(response.code != 200){
            return response.newBuilder().code(200).message("Error").build()
        }

        return response
    }
}