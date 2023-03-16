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
        Log.d( "InterceptorResponse: ", "${request.url} ${response.peekBody(2048).string()}")

        return response
    }
}