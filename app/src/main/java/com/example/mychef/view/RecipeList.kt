package com.example.mychef.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.mychef.NavMenu
import com.example.mychef.R
import com.example.mychef.data.DataProvider
import com.example.mychef.model.Category

private val categoryList: List<String> = Category.values().map { it.displatName }


@Composable
fun RecipeList(navController: NavController) {
    val scrollState = rememberLazyListState()
    val tabs = getTabList()
    Column(Modifier.fillMaxSize()) {
        val selectedTabIndexState = remember { mutableStateOf(0) }
        val selectedTabIndex = selectedTabIndexState.value

        NavMenu(navController)

        CustomScrollableTabRow(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
        ) { tabIndex ->
            selectedTabIndexState.value = tabIndex
        }
        val selectedCategory = tabs.getOrNull(selectedTabIndex)
        val recipes = DataProvider.getRecipiesByCategory(selectedCategory.toString())

        if (selectedCategory == "Home") {
            Text(text = "Karta główna będzie informować o  przeznaczeniu aplikacji")
        } else {
            LazyColumn(state = scrollState) {
                val rows = recipes.chunked(2)
                items(rows) { row ->
                    Row(Modifier.fillMaxWidth()) {
                        row.forEach { recipe ->
                            ImageCardForPhone(
                                painter = recipe.image,
                                contentDescription = recipe.name,
                                title = recipe.name,
                                navController = navController,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(16.dp)
                            )
                        }
                        if (row.size == 1) {
                            Spacer(Modifier.weight(1f))
                        }
                    }
                }

            }
        }
    }
}


@Composable
fun ImageCardForPhone(
    navController: NavController,
    painter: Int,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = {
                navController.navigate(R.id.detailRecipeFragment, bundleOf("recipe" to title))
            }),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painterResource(painter),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 24.sp))
            }
        }
    }
}

fun getTabList(): List<String> {
    return listOf("Home") + categoryList
}

