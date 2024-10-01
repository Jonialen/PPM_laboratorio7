package com.example.myapplication.ui.mealdetail.repository

import com.example.myapplication.networking.MealsWebService
import com.example.myapplication.networking.response.MealslookupEscovitchFishResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsdetailRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMealslookupEscovitchFish(successCallback: (response: MealslookupEscovitchFishResponse?) -> Unit) {
        return webService.getMealslookupEscovitchFish().enqueue(object : Callback<MealslookupEscovitchFishResponse> {
            override fun onResponse(
                call: Call<MealslookupEscovitchFishResponse>,
                response: Response<MealslookupEscovitchFishResponse>
            ) {
                if (response.isSuccessful)
            successCallback(response.body())
            }

            override fun onFailure(call: Call<MealslookupEscovitchFishResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}