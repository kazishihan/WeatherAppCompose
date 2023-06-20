package com.example.weatherappcompose.repository

import com.example.weatherappcompose.data.DataOrException
import com.example.weatherappcompose.model.Weather
import com.example.weatherappcompose.model.WeatherObject
import com.example.weatherappcompose.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(): DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather()
        } catch (e: Exception) {
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }
}