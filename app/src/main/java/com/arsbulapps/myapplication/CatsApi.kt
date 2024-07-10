package com.arsbulapps.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatsApi { // Интерфейс для прописывания запросов
      @GET("/fact") // get-запрос на получение данных по маршруту "fact"
    fun getFact(@Query("max_length") maxLength: Int): Call<FactResponse> // Объявление метода запроса данных и указание типа получаемого ответа
}