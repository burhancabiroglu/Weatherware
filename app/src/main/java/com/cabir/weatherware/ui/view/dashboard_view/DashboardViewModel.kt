package com.cabir.weatherware.ui.view.dashboard_view

import androidx.lifecycle.*
import kotlinx.coroutines.launch;
import com.cabir.weatherware.core.base.Resource
import com.cabir.weatherware.data.ApiRepository
import com.cabir.weatherware.data.entity.Weather
import com.cabir.weatherware.data.entity.WeatherReport
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val apiRepository: ApiRepository): ViewModel() {

    private lateinit var weatherReport:LiveData<Resource<WeatherReport>>;


    init {
        weatherReport = getSampleWeatherData();

    }

     fun getSampleWeatherData():LiveData<Resource<WeatherReport>>{
          return apiRepository.getWeatherData(latitude = 40.0,longitude = 10.0);
     }

}