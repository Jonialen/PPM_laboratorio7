package com.example.myapplication.networking

import com.example.myapplication.networking.response.MealsCategoriesResponse
import com.example.myapplication.networking.response.MealsFilterResponse
import com.example.myapplication.networking.response.MealslookupResponse
import retrofit2.Call
import retrofit2.http.GET

interface MealsApi {
    @GET("categories.php")
    fun getMealsCategories(): Call<MealsCategoriesResponse>

    @GET("filter.php?c=Seafood")
    fun getMealsFilter(): Call<MealsFilterResponse>

    @GET("lookup.php?i=52944")
    fun getMealslookup(): Call<MealslookupResponse>
}