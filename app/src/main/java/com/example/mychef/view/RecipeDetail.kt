package com.example.mychef.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mychef.data.DataProvider

@Composable
fun DetailRecipe(name: String?) {
    val scrollState = rememberScrollState()
    val recipe = DataProvider.getRecipeByName(name.toString())
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(id = recipe.image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = recipe.name,
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Lista składników",
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        recipe.ingredients.forEach { ingredient ->
            Text(
                text = "- $ingredient",
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Text(
            text = "Przepis:",
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = 8.dp)
        )
        recipe.steps.forEach { step ->
            Text(
                text = "- $step",
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}