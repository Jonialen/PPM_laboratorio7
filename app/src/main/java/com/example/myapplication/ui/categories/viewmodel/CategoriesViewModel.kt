package com.example.myapplication.ui.categories.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.networking.response.MealsCategoriesResponse
import com.example.myapplication.ui.categories.repository.CategoriesRepository

class CategoriesViewModel (private val repository: CategoriesRepository = CategoriesRepository()): ViewModel() {
    fun getMealsCategories(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMealsCategories { response ->
            successCallback(response)
        }
    }
}