package com.example.myapplication.ui.categories.repository

import com.example.myapplication.networking.MealsWebService
import com.example.myapplication.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMealsCategories(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        return webService.getMealsCategories().enqueue(object : Callback<MealsCategoriesResponse> {
            override fun onResponse(
                call: Call<MealsCategoriesResponse>,
                response: Response<MealsCategoriesResponse>
            ) {
                if (response.isSuccessful)
            successCallback(response.body())
            }

            override fun onFailure(call: Call<MealsCategoriesResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}