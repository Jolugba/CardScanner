package com.example.cardscanner.di

import com.example.cardscanner.BuildConfig
import com.example.cardscanner.network.ApiDataSource
import com.example.cardscanner.network.CardService
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Singleton
    @Provides
    fun provideRetrofit(
        loggingInterceptor: HttpLoggingInterceptor
    ): Retrofit {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor {
                val request  = it.request()
                    .newBuilder()
                    .addHeader("Accept-Version", "3")
                    .build()
                it.proceed(request)
            }
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(StethoInterceptor())
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .build()
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl(APP_BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val logLevel =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = logLevel
        return loggingInterceptor
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): CardService =
        retrofit.create(CardService::class.java)
    @Provides
    @Singleton
    fun provideApiDataSource(apiService: CardService) = ApiDataSource(apiService)

    companion object {
        const val APP_BASE_URL = BuildConfig.APP_BASE_URL
    }


}
