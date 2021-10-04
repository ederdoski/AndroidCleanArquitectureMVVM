package com.adrena.basearchitect.core.internal

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.logging.Level


private const val BASE_URL = "https://moneelyte.herokuapp.com/"

val networkModule = module {
    single { providerRetrofit() }
}

fun providerRetrofit(): Retrofit {
    return generateRetrofit()
}

private fun generateRetrofit(): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(getLoggerInterceptor())
        .build()
}

fun getLoggerInterceptor(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    val httpClient = OkHttpClient.Builder()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    httpClient.addInterceptor(logging)
    return httpClient.build()
}
