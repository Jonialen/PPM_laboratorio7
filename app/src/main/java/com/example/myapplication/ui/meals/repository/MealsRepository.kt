package com.example.myapplication.ui.meals.repository

import com.example.myapplication.networking.MealsWebService
import com.example.myapplication.networking.response.MealsFilterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMealsFilter(successCallback: (response: MealsFilterResponse?) -> Unit) {
        return webService.getMealsFilter().enqueue(object : Callback<MealsFilterResponse> {
            override fun onResponse(
                call: Call<MealsFilterResponse>,
                response: Response<MealsFilterResponse>
            ) {
                if (response.isSuccessful)
            successCallback(response.body())
            }

            override fun onFailure(call: Call<MealsFilterResponse>, t: Throwable) {
                println("Error en la llamada a la API: ${t.message}")
                successCallback(null) // O bien manejarlo de otra manera
            }
        })
    }
}