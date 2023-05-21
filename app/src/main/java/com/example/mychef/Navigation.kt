package com.example.mychef

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.mychef.view.CategoryList
import com.example.mychef.view.DetailRecipe
import com.example.mychef.view.RecipeList


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CategoryList.route) {
        composable(route = Screen.CategoryList.route) {
            CategoryList(navController = navController)
        }
        composable(
            route = Screen.RecipeList.route + "/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            RecipeList(category = entry.arguments?.getString("category"), navController)
        }

        composable(
            route = Screen.DetailRecipe.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            DetailRecipe(name = entry.arguments?.getString("name"))
        }
    }
}





