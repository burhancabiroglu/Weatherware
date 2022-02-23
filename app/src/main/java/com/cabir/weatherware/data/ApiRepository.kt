package com.cabir.weatherware.data

import com.cabir.weatherware.BuildConfig
import com.cabir.weatherware.core.strategy.performNetworkOperation
import com.cabir.weatherware.data.locale.LocalDataSource
import com.cabir.weatherware.data.remote.RemoteDataSource
import javax.inject.Inject


class ApiRepository @Inject
constructor(
    private var remoteDataSource: RemoteDataSource,
    private var localDataSource: LocalDataSource
) {
    // TODO: REMOTE DATA PROCESS
    fun getWeatherData(latitude:Double,longitude:Double) = performNetworkOperation {
        remoteDataSource.getWeatherData(latitude,longitude)
    }
}