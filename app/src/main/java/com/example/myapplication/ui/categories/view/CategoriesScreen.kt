package com.example.myapplication.ui.categories.view

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
import com.example.myapplication.networking.response.MealsCatergories
import com.example.myapplication.ui.categories.viewmodel.CategoriesViewModel

@Composable
fun CategoriesScreen(viewModel: CategoriesViewModel = viewModel()) {
    var categories by remember { mutableStateOf(emptyList<MealsCatergories>()) }

    // Llama al ViewModel para obtener las categorías
    viewModel.getMealsCategories { response ->
        response?.categories?.let {
            categories = it
        }
    }

    // Muestra la lista de categorías
    CategoryList(categories = categories)
}

@Composable
fun CategoryList(categories: List<MealsCatergories>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(categories) { category ->
            CategoryCard(category = category)
        }
    }
}

@Composable
fun CategoryCard(category: MealsCatergories) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Carga la imagen usando Coil
            Image(
                painter = rememberAsyncImagePainter(model = category.strCategoryThumb),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = category.strCategory,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = category.strCategoryDescription,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
