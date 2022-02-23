package com.cabir.weatherware.data.remote

import com.cabir.weatherware.core.base.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) : BaseDataSource() {
    suspend fun getWeatherData(latitude:Double,Longitude:Double) = getResult {
        apiService.getWeatherData(
            latitude = latitude,
            longitude = Longitude,
            units = "metric",
            exclude = "minutely,hourly"
        )
    }
}