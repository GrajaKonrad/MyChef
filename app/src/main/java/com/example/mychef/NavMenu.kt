package com.example.mychef.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mychef.R


@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    name = "Titlebar Preview"
)
@Composable
fun NavMenu() {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "blablba",
                Modifier.height(30.dp)
            )
        },
        actions =
        {
            Icon(
                painter = painterResource(id = androidx.appcompat.R.drawable.abc_ic_search_api_material),
                contentDescription = null
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Cyan
        )
    )
}

