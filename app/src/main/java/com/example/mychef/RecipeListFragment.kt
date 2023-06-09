package com.example.mychef

import RecipeScreen
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.booleanResource
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mychef.view.RecipeList

class RecipeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = ComposeView(requireContext())
        val navController = findNavController()
        view.apply {
            setContent {
                if (booleanResource(id = R.bool.is_tablet)) {
                    RecipeScreen(requireContext())
                } else {
                    RecipeList(navController = navController)
                }
            }
        }
        return view
    }

}



