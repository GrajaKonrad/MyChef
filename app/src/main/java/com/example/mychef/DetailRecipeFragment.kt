package com.example.mychef

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.mychef.view.DetailRecipe

class DetailRecipeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = ComposeView(requireContext())
        val recipe = arguments?.getString("recipe")
        view.apply {
            setContent {
                Column {
                    DetailRecipe(recipe)
                    FloatingActionButton(
                        onClick = { showMessage() },
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.End)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            tint = Color.Blue
                        )
                    }
                }
            }
        }
        return view
    }

    private fun showMessage() {
        Toast.makeText(requireContext(), "Button clicked!", Toast.LENGTH_SHORT).show()
    }
}