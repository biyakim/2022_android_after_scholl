package com.example.weatherdustchecker

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {
    //https://api.openweathermap.org/data/2.5/weather?units=metric&lat=${lat}&lon=${lon}&appid=${APP_ID}
    //URL을 구성하는 메서드
    @GET("/data/2.5/weather") //경로
    fun getWeatherStatusInfo(
        @Query("appid") appId: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String = "metric"
    ) : Call<OpenWeatherAPIJSONResponseGSON> //OpenWeatherAPIJSONResponseGSON 역직렬화 클래스 만들기
}

data class OpenWeatherAPIJSONResponseGSON(
    val main: Map<String, String>,
    val weather: List<Map<String, String>>)