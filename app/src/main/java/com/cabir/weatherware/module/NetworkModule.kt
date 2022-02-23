package com.cabir.weatherware.module

import android.os.Build
import com.cabir.weatherware.BuildConfig
import com.cabir.weatherware.data.remote.ApiService
import com.cabir.weatherware.data.remote.RemoteDataSource
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson,
        endPoint: EndPoint
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(endPoint.url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideEndPoint(): EndPoint {
        return EndPoint("https://api.openweathermap.org/")
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.addInterceptor {
            val url = it.request().url.newBuilder().addQueryParameter("appid",BuildConfig.API_KEY).build();
            it.proceed(it.request().newBuilder().url(url=url).build())
        }
        builder.interceptors().add(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })

        return builder.build()
    }


    @Provides
    fun provideGson(): Gson {
        return Gson()
    }


    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSource(apiService)
    }

}

data class EndPoint(val url: String)