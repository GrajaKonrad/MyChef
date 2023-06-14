package com.example.mychef


import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.mychef.R
import com.example.mychef.data.DataProvider
import com.example.mychef.model.Recipe


@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    name = "Titlebar Preview"
)
@Composable
fun NavMenu(
    navController: NavController
    ) {
    var search_clicked by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var recipes by remember { mutableStateOf(listOf<Recipe>())}
    TopAppBar(
        title = {
            if(!search_clicked)
            {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(id = R.string.logo_description),
                    Modifier.height(50.dp)
                )
            }
            else
            {
                Image(
                    painter = painterResource(id = R.drawable.min_logo),
                    contentDescription = stringResource(id = R.string.logo_description),
                    Modifier.height(52.dp)
                )
            }

        },
        actions =
        {
            if(!search_clicked) {
                Button(
                    onClick = { search_clicked = true },
                    colors = ButtonDefaults.textButtonColors()
                ) {
                    Icon(
                        painter = painterResource(id = androidx.appcompat.R.drawable.abc_ic_search_api_material),
                        contentDescription = null,
                    )
                }
            }else
            {
                TextField(
                    value = text,
                    shape = RoundedCornerShape(15.dp),
                    onValueChange = {
                            newText -> text = newText
                            recipes = DataProvider.getRecipeByPartName(text.text)
                            expanded = true
                                    },
                    modifier = Modifier
                        .padding(30.dp)
                        .widthIn(0.dp, 230.dp)
                        .size(width = 230.dp, height = 40.dp)
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    properties = PopupProperties(focusable = false)
                ) {
                    recipes.forEach { row ->
                        DropdownMenuItem(
                            text = { Text(row.name) },
                            onClick = {
                                navController.navigate(
                                    R.id.detailRecipeFragment,
                                    bundleOf("recipe" to row.name)
                                )
                            }
                        )
                    }
                }
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .drawBehind {

                val strokeWidth = 300 * density
                val y = size.height - strokeWidth / 2

                drawLine(
                    Color.Black,
                    Offset(0f, y),
                    Offset(size.width, y),
                    strokeWidth
                )
            }
    )
}
