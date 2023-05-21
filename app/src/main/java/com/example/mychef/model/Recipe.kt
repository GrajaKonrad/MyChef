package com.example.mychef.model


data class Recipe(var category: String, var name: String, var ingredients: List<String>,
             var steps: List<String>, var image: Int) {

}