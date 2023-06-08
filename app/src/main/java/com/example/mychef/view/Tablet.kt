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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mychef.data.DataProvider
import com.example.mychef.view.DetailRecipe
import com.example.mychef.view.RecipeList

var selectedRecipe: MutableState<String?> = mutableStateOf(null)


@Composable
fun RecipeScreen(category: String?, navController: NavController) {

    Row(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.weight(1f)) {
            RecipeList(category = category, navController = navController)
        }

        Column(modifier = Modifier.weight(1f)) {
            if (selectedRecipe.value != null) {
                DetailRecipe(name = selectedRecipe.value)
            }
        }
    }
}

@Composable
fun RecipeList(category: String?) {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        val recipies = DataProvider.getRecipiesByCategory(category.toString())
        val rows = recipies.chunked(2)
        items(rows) { row ->
            Row(Modifier.fillMaxWidth()) {
                row.forEach { recipe ->
                    ImageCard(
                        painter = recipe.image,
                        contentDescription = recipe.name,
                        title = recipe.name,
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

@Composable
fun ImageCard(
    painter: Int,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = {
                //navController.navigate(R.id.detailRecipeFragment, bundleOf("recipe" to title))
                selectedRecipe.value = title
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
                contentScale = ContentScale.Crop
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
