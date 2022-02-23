package com.cabir.weatherware.data.remote

import com.cabir.weatherware.data.entity.WeatherReport
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import kotlinx.parcelize.Parcelize

interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("/data/2.5/onecall")
    suspend fun getWeatherData(
        @Query("lat") latitude:Double,
        @Query("lon") longitude:Double,
        @Query("exclude") exclude:String,
        @Query("units") units:String,
    ): Response<WeatherReport>
}