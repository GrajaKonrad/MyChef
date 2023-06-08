package com.example.mychef

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mychef.view.CategoryList
import selectedRecipe

class CategoryListFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        selectedRecipe.value = null
        val navController = findNavController()
        val view = ComposeView(requireContext())
        view.apply {
            setContent {
                CategoryList(navController)
            }
        }
        return view
    }
}