package com.aulia.idn.newsapp.di

import com.aulia.idn.newsapp.data.source.APIService
import com.aulia.idn.newsapp.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//buat mengatur function2 apa aja yg mau di provide via dagger hilt,
//karena kita udh meninjek si api ke dalam repository,
//repository ke model
//api service butuh konfigurasi retrofit,
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    //memprovide api
    fun ProvideAPI(): APIService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(APIService::class.java)
    }
}