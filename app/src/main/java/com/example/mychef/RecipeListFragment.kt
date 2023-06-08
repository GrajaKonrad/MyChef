package com.example.mychef

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mychef.view.RecipeList

class RecipeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val category = arguments?.getString("category")
        val view = ComposeView(requireContext())
        val navController = findNavController()
        view.apply {
            setContent {
                RecipeList(category = category, navController)
            }
        }
        return view
    }

}



