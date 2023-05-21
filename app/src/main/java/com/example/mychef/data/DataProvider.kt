package com.example.mychef.data

import com.example.mychef.R
import com.example.mychef.model.Category
import com.example.mychef.model.Recipe

object DataProvider {

    val recipies = listOf(
        Recipe(
            Category.ITALIAN.displatName, "Spaghetti", listOf(
            "mąka", "jaja"), listOf("przygotować", "pokroic", "ugotowac"), R.drawable.spaghetti),
        Recipe(Category.DESSERT.displatName, "Naleśniki", listOf(
            "mąka", "jaja"), listOf("przygotować", "pokroic", "ugotowac"), R.drawable.nalesniki),
        Recipe(Category.ITALIAN.displatName, "Lasagne", listOf(
            "mąka", "jaja"), listOf("przygotować", "pokroic", "ugotowac"), R.drawable.lasagne),
        Recipe(Category.DESSERT.displatName, "Sernik", listOf(
            "mąka", "jaja"), listOf("przygotować", "pokroic", "ugotowac"), R.drawable.sernik),
        Recipe(Category.DESSERT.displatName, "Pączki", listOf(
            "mąka", "jaja"), listOf("przygotować", "pokroic", "ugotowac"), R.drawable.paczki),
        Recipe(Category.APPETIZER.displatName, "Rosół", listOf(
            "mąka", "jaja"), listOf("przygotować", "pokroic", "ugotowac"), R.drawable.rosol),
        Recipe(Category.TURKISH.displatName, "Kebab", listOf(
            "mąka", "jaja"), listOf("przygotować", "pokroic", "ugotowac"), R.drawable.kebab),
        Recipe(Category.SALAD.displatName, "Sałatka", listOf(
            "mąka", "jaja"), listOf("przygotować", "pokroic", "ugotowac"), R.drawable.salatka),
        Recipe(Category.POLISH.displatName, "Zapiekanka", listOf(
            "mąka", "jaja"), listOf("przygotować", "pokroic", "ugotowac"), R.drawable.zapiekanka),
        Recipe(Category.POLISH.displatName, "Pieczeń", listOf(
            "mąka", "jaja"), listOf("przygotować", "pokroic", "ugotowac"), R.drawable.pieczen)
    )

    fun getRecipiesByCategory(category: String): List<Recipe> {
        return recipies.filter {
                recipe -> category.equals(recipe.category) }
    }

    fun getRecipeByName(name: String): Recipe {
        return recipies.filter { recipe ->
            name.equals(recipe.name)
        }.first()
    }
}