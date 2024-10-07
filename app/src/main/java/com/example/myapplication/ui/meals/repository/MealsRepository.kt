package com.example.myapplication.ui.meals.repository

import com.example.myapplication.networking.MealsWebService
import com.example.myapplication.networking.response.MealsSeafoodFilterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMealsFilter(successCallback: (response: MealsSeafoodFilterResponse?) -> Unit) {
        return webService.getMealsSeafoodFilter().enqueue(object : Callback<MealsSeafoodFilterResponse> {
            override fun onResponse(
                call: Call<MealsSeafoodFilterResponse>,
                response: Response<MealsSeafoodFilterResponse>
            ) {
                if (response.isSuccessful)
            successCallback(response.body())
            }

            override fun onFailure(call: Call<MealsSeafoodFilterResponse>, t: Throwable) {
                println("Error en la llamada a la API: ${t.message}")
                successCallback(null) // O bien manejarlo de otra manera
            }
        })
    }
}