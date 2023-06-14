package com.example.mychef.data

import com.example.mychef.R
import com.example.mychef.model.Category
import com.example.mychef.model.Recipe

object DataProvider {

    val recipies = listOf(
        Recipe(
            Category.ITALIAN.displatName,
            "Spaghetti",
            listOf("mąka", "jaja", "pomidor"),
            listOf("przygotować", "pokroic", "ugotowac"),
            R.drawable.spaghetti,
            listOf(61000,180000, 30000)
        ),
        Recipe(
            Category.DESSERT.displatName,
            "Naleśniki",
            listOf("mąka", "jaja"),
            listOf("przygotować", "pokroic", "ugotowac"),
            R.drawable.nalesniki,
            listOf(685000,90000)
        ),
        Recipe(
            Category.ITALIAN.displatName,
            "Lasagne",
            listOf("mąka", "jaja"),
            listOf("przygotować", "pokroic", "ugotowac"),
            R.drawable.lasagne,
            listOf(61000,90000)
        ),
        Recipe(
            Category.DESSERT.displatName,
            "Sernik",
            listOf("mąka", "jaja"),
            listOf("przygotować", "pokroic", "ugotowac"),
            R.drawable.sernik,
            listOf(70000,90000)
        ),
        Recipe(
            Category.DESSERT.displatName,
            "Pączki",
            listOf("mąka", "jaja"),
            listOf("przygotować", "pokroic", "ugotowac"),
            R.drawable.paczki,
            listOf(61000,90000)
        ),
        Recipe(
            Category.APPETIZER.displatName,
            "Rosół",
            listOf("mąka", "jaja"),
            listOf("przygotować", "pokroic", "ugotowac"),
            R.drawable.rosol,
            listOf(61000,90000)
        ),
        Recipe(
            Category.TURKISH.displatName,
            "Kebab",
            listOf("mąka", "jaja"),
            listOf("przygotować", "pokroic", "nawinąć"),
            R.drawable.kebab,
            listOf(63000,90000)
        ),
        Recipe(
            Category.SALAD.displatName,
            "Sałatka",
            listOf("sałata", "jaja"),
            listOf("przygotować", "pokroic"),
            R.drawable.salatka,
            listOf(61000,81000)
        ),
        Recipe(
            Category.POLISH.displatName,
            "Zapiekanka",
            listOf("mąka", "jaja"),
            listOf("przygotować", "pokroic", "ugotowac"),
            R.drawable.zapiekanka,
            listOf(61000,900000)
        ),
        Recipe(
            Category.POLISH.displatName,
            "Pieczeń",
            listOf("mięso", "przyprawy"),
            listOf("przygotować", "usmażyć", "zapiec"),
            R.drawable.pieczen,
            listOf(61000,3600000)
        )
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

    fun getRecipeByPartName(part: String): List<Recipe> {
        return recipies.filter { recipe ->
            recipe.name.contains(part)
        }
    }
}