package com.example.mychef.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.example.mychef.data.DataProvider
import kotlinx.coroutines.delay

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
        recipe.times.forEach { timer ->
            Timer(timer)
        }
    }
}
@Composable
fun Timer(
    timeBegin: Long
)
{
    var currentTime by remember {
        mutableStateOf(timeBegin)
    }
    var isTimerStart by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currentTime, key2 = isTimerStart) {
        if(currentTime > 0 && isTimerStart) {
            delay(100L)
            currentTime -= 100L
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){

    Button(
        onClick = {
                    if(currentTime <= 0L) {
                        currentTime = timeBegin
                        isTimerStart = true
                    } else {
                        isTimerStart = !isTimerStart
                    }
                  },
        modifier = Modifier
                        .padding(5.dp)
                        .size(width = 25.dp, height = 25.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (!isTimerStart || currentTime <= 0L) {
                Color.Green
            } else {
                Color.Red
            }
        ),
        shape = RoundedCornerShape(28.dp),
        contentPadding = PaddingValues(5.dp)
    ) {
        Icon(
            if(!isTimerStart || currentTime <= 0L)
            {
                Icons.Rounded.PlayArrow
            } else
            {
                Icons.Rounded.Done
            },
            modifier = Modifier.size(20.dp),
            contentDescription = "time icon",
            tint = Color.Unspecified
        )
    }
    Text(
        text = (currentTime / 60000L).toString() + "min " + ((currentTime % 60000L) / 1000).toString() + "sec",
        modifier = Modifier.padding(start = 2.dp),
        fontSize = 14.sp,
        color = Color.Black
    )
    }
}