package com.example.myapplication.ui.meals.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.networking.response.MealsFilterResponse
import com.example.myapplication.ui.meals.repository.MealsRepository

class MealsViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMealsFilter (successCallback: (response: MealsFilterResponse?) -> Unit) {
        repository.getMealsFilter { response ->
            successCallback(response)
        }
    }
}