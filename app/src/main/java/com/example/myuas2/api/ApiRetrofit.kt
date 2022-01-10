package com.example.myuas2.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRetrofit {
    val endpoint: ApiEndpoint
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.43.213/handphone/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiEndpoint::class.java)
        }

    private fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.43.213/handphone/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getInstance(): ApiEndpoint {
        return getRetrofitClient().create(ApiEndpoint::class.java)
    }
}
