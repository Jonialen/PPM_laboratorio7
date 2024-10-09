package com.example.myapplication.ui.mealdetail.repository

import com.example.myapplication.networking.MealsWebService
import com.example.myapplication.networking.response.MealslookupResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsdetailRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMealslookup(successCallback: (response: MealslookupResponse?) -> Unit) {
        return webService.getMealslookup().enqueue(object : Callback<MealslookupResponse> {
            override fun onResponse(
                call: Call<MealslookupResponse>,
                response: Response<MealslookupResponse>
            ) {
                if (response.isSuccessful)
            successCallback(response.body())
            }

            override fun onFailure(call: Call<MealslookupResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}