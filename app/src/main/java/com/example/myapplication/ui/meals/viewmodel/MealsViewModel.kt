package com.example.myapplication.ui.meals.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.networking.response.MealsSeafoodFilterResponse
import com.example.myapplication.ui.meals.repository.MealsRepository

class MealsViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMealsSeafoodFilter (successCallback: (response: MealsSeafoodFilterResponse?) -> Unit) {
        repository.getMealsSeafoodFilter { response ->
            successCallback(response)
        }
    }
}