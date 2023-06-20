package com.example.weatherappcompose.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappcompose.data.DataOrException
import com.example.weatherappcompose.model.Weather
import com.example.weatherappcompose.model.WeatherObject
import com.example.weatherappcompose.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repo: WeatherRepository) : ViewModel() {
    val data: MutableState<DataOrException<WeatherObject, Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, null)
    )
    suspend fun getWeatherData():DataOrException<Weather,Boolean,Exception>{
        return repo.getWeather()
    }
}