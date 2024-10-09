package com.example.myapplication.navegation


import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.categories.view.CategoriesScreen
import com.example.myapplication.ui.mealdetail.view.MealDetailScreen
import com.example.myapplication.ui.meals.view.MealsScreen


@Composable
fun AppNavigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.CategoriesScreen.route, modifier = modifier){
        composable(route = AppScreens.CategoriesScreen.route){
            CategoriesScreen(navController = navController)
        }
        composable(route = AppScreens.MealsScreen.route){
            MealsScreen(navController = navController)
        }
        composable(route = AppScreens.MealDetailScreen.route){
            MealDetailScreen(navController = navController)
        }
    }
}