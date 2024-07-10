package com.arsbulapps.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val retrofitBuilder: Retrofit = Retrofit.Builder()
        .baseUrl("https://catfact.ninja") // Установка домена (адреса)
        .addConverterFactory(GsonConverterFactory.create()) // Инициализация конвертера из json в data class. GsonConverterFactory привязывается к retrofit.Builder
        .build()
    val catsApi: CatsApi = retrofitBuilder.create(CatsApi::class.java) // Инициализация запросов для последующего получения данных или последующей отправки данных
}