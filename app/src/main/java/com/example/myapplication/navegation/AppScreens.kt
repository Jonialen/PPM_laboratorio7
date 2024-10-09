package com.example.myapplication.navegation

sealed class AppScreens(val route: String) {
    object CategoriesScreen: AppScreens("CategoriesScreen")
    object MealDetailScreen: AppScreens("MealDetailScreen")
    object MealsScreen: AppScreens("MealsScreen")
}