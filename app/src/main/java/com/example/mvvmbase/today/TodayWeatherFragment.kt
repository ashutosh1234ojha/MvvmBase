package com.example.mvvmbase.today

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.mvvmbase.R
import com.example.mvvmbase.data.network.ApixuWeatherApiService
import com.example.mvvmbase.data.network.ConnectivityInterceptorImpl
import com.example.mvvmbase.data.network.WeatherNetworkDataSourceImpl
import kotlinx.android.synthetic.main.today_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TodayWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = TodayWeatherFragment()
    }

    private lateinit var viewModel: TodayWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.today_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TodayWeatherViewModel::class.java)

        val apiService = ApixuWeatherApiService(ConnectivityInterceptorImpl(this.context!!))
        val weatherNetworkDataSource=WeatherNetworkDataSourceImpl(apiService)

        weatherNetworkDataSource._downloadedCurrentWeather.observe(this, Observer {
            tvText.text=it.toString()
        })
        GlobalScope.launch(Dispatchers.Main) {
           weatherNetworkDataSource.fetchCurrentWeather("London","en")
        }
    }

}
