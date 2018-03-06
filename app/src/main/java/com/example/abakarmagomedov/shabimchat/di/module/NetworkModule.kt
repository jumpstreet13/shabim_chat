package com.example.abakarmagomedov.shabimchat.di.module

import com.example.abakarmagomedov.shabimchat.BuildConfig
import com.example.abakarmagomedov.shabimchat.data.network.ShabimApi
import com.example.abakarmagomedov.shabimchat.di.scope.PerApplication
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */

@Module
class NetworkModule {

    val BASE_URL = "http://staging.beender-app.com/api/"

    @PerApplication
    @Provides
    fun providesHttpLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @PerApplication
    @Provides
    fun provideOkHttpClient(logging: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addNetworkInterceptor(logging)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }.build()
    }


    @PerApplication
    @Provides
    fun provideShabimApi(httpClient: OkHttpClient, gson: Gson): ShabimApi {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(httpClient)
                .baseUrl(BASE_URL)
                .build().create(ShabimApi::class.java)
    }
}