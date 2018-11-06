package com.devforfun.launchapp.di;

import com.devforfun.launchapp.BuildConfig
import com.devforfun.launchapp.api.LauncherApi
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [OkHttpClientModule::class])
class NetworkModule {

    @Singleton
    @Provides
    fun api(retrofit: Retrofit): LauncherApi {
        return retrofit.create(LauncherApi::class.java)
    }

    @Singleton
    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}