package com.cabir.weatherware.ui.view.dashboard_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.cabir.weatherware.core.base.Resource
import com.cabir.weatherware.data.entity.WeatherReport
import com.cabir.weatherware.databinding.DashboardViewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DashboardView:Fragment() {

    private lateinit var binding: DashboardViewBinding
    private  val viewModel:DashboardViewModel by viewModels();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DashboardViewBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getSampleWeatherData().observe(viewLifecycleOwner, DashboardViewObserver())
        super.onViewCreated(view, savedInstanceState)
    }



    inner class DashboardViewObserver(): Observer<Resource<WeatherReport>>{
        override fun onChanged(t: Resource<WeatherReport>) {
            when(t.status){
                Resource.Status.SUCCESS -> null;
            }
        }

    }


}