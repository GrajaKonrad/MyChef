package com.example.mychef

sealed class Screen(val route: String) {
    object CategoryList: Screen("main_screen")
    object RecipeList: Screen("recipe_screen")
    object DetailRecipe: Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
