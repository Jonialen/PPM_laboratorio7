package com.example.myapplication.ui.meals.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.networking.response.MealsSeafoodFilter
import com.example.myapplication.ui.meals.viewmodel.MealsViewModel

@Composable
fun MealsScreen(viewModel: MealsViewModel = viewModel()) {
    var meals by remember { mutableStateOf(emptyList<MealsSeafoodFilter>()) }

    // Llama al ViewModel para obtener las comidas filtradas
    viewModel.getMealsFilter { response ->
        response?.meals?.let {
            meals = it
        }
    }

    // Muestra la lista de comidas
    SeafoodFilterList(meals = meals)
}

@Composable
fun SeafoodFilterList(meals: List<MealsSeafoodFilter>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(meals) { meal ->
            SeafoodFilterCard(meal = meal)
        }
    }
}

@Composable
fun SeafoodFilterCard(meal: MealsSeafoodFilter) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Carga la imagen usando Coil
            Image(
                painter = rememberAsyncImagePainter(model = meal.strMealThumb),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = meal.strMeal,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}