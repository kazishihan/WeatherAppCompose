package com.example.weatherappcompose.network


import com.example.weatherappcompose.model.Weather
import com.example.weatherappcompose.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET(value = "data/2.5/forecast")
    suspend fun getWeather(
        @Query("lat")lat:String="44.34",
        @Query("lon")lon:String="10.99",
        @Query("appid")appid:String=Constant.API_KEY,
    ):Weather
}