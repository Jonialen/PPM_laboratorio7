package com.example.myapplication.ui.mealdetail.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.networking.response.MealslookupEscovitchFishResponse
import com.example.myapplication.ui.mealdetail.repository.MealsdetailRepository


class MealsdetailViewModel (private val repository: MealsdetailRepository = MealsdetailRepository()): ViewModel() {
    fun getMealslookupEscovitchFish(successCallback: (response: MealslookupEscovitchFishResponse?) -> Unit) {
        repository.getMealslookupEscovitchFish { response ->
            successCallback(response)
        }
    }
}