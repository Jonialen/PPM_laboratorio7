package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.categories.view.CategoriesScreen
import com.example.myapplication.ui.mealdetail.view.MealDetailScreen
import com.example.myapplication.ui.meals.view.MealsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme  {
                Surface {
                    // Llama a la pantalla de categorías para probar
                    MealsScreen()
                }
            }
        }
    }
}