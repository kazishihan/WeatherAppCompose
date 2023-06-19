package com.example.weatherappcompose.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappcompose.data.DataOrException
import com.example.weatherappcompose.model.WeatherObject
import com.example.weatherappcompose.repository.WeatherRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(val repo: WeatherRepository) : ViewModel() {
    val data: MutableState<DataOrException<WeatherObject, Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, null)
    )
    
    init {
        loadWeather()
    }
    
    private fun loadWeather() {
        getWeather()
    }
    
    private fun getWeather() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repo.getWeather()
            if (data.value.data.toString().isNotEmpty()) data.value.loading = false
        }
        Log.d("GTE", "getWeather: ${data.value.data.toString()} ")
    }
}