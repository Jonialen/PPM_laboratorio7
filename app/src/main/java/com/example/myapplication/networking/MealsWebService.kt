package com.example.myapplication.networking

import com.example.myapplication.networking.response.MealsCategoriesResponse
import com.example.myapplication.networking.response.MealsSeafoodFilterResponse
import com.example.myapplication.networking.response.MealslookupEscovitchFishResponse
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory

public class MealsWebService {
    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    fun getMealsCategories(): Call<MealsCategoriesResponse> {
        return api.getMealsCategories()
    }

    fun getMealsSeafoodFilter(): Call<MealsSeafoodFilterResponse> {
        return api.getMealsSeafoodFilter()
    }

    fun getMealslookupEscovitchFish(): Call<MealslookupEscovitchFishResponse> {
        return api.getMealslookupEscovitchFish()
    }
}
