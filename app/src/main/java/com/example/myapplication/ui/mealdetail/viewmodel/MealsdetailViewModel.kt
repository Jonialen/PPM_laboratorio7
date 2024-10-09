package com.example.myapplication.ui.mealdetail.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.networking.response.MealslookupResponse
import com.example.myapplication.ui.mealdetail.repository.MealsdetailRepository


class MealsdetailViewModel (private val repository: MealsdetailRepository = MealsdetailRepository()): ViewModel() {
    fun getMealslookup(successCallback: (response: MealslookupResponse?) -> Unit) {
        repository.getMealslookup { response ->
            successCallback(response)
        }
    }
}