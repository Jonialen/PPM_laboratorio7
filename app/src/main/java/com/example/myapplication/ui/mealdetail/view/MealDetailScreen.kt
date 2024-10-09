package com.example.myapplication.ui.mealdetail.view

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
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.networking.response.Mealslookup
import com.example.myapplication.ui.mealdetail.viewmodel.MealsdetailViewModel

@Composable
fun MealDetailScreen(navController: NavController, viewModel: MealsdetailViewModel = viewModel()) {
    var meals by remember { mutableStateOf(emptyList<Mealslookup>()) }

    // Llama al ViewModel para obtener los detalles de la comida
    viewModel.getMealslookup { response ->
        response?.meals?.let {
            meals = it
        }
    }

    // Verifica si los datos están disponibles
    if (meals.isNotEmpty()) {
        MealList(meals = meals)
    } else {
        // Muestra un mensaje de carga o error
        Text(
            text = "Cargando detalles de la comida...",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxSize().wrapContentHeight()
        )
    }
}

@Composable
fun MealList(meals: List<Mealslookup>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(meals) { meal ->
            MealCard(meal = meal)
        }
    }
}

@Composable
fun MealCard(meal: Mealslookup) {  // Asegúrate de que el tipo de meal sea el correcto
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
                contentDescription = meal.strMeal,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Muestra el nombre del plato
            Text(
                text = meal.strMeal,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            // Muestra la categoría
            Text(
                text = "Categoría: ${meal.strCategory}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
            // Muestra el área
            Text(
                text = "Área: ${meal.strArea}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Muestra las instrucciones
            Text(
                text = "Instrucciones:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = meal.strInstructions,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
