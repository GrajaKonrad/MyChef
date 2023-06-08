package com.example.mychef.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.mychef.R
import com.example.mychef.model.Category


private val categoryList: List<String> = Category.values().map { it.displatName }


@Composable
fun CategoryList(navController: NavController) {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        items(categoryList) { category ->
            Card(
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clickable(onClick = {
                        navController.navigate(
                            R.id.recipeListFragment,
                            bundleOf("category" to category)
                        )
                    })
            ) {
                Text(
                    text = category,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(vertical = 24.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}
