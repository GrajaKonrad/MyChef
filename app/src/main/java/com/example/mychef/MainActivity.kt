package com.example.mychef

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainBody()
        }
//        setContentView(R.layout.activity_main)
//        // use arrayadapter and define an array
//        val arrayAdapter: ArrayAdapter<*>
//        val users = arrayOf(
//            "Virat Kohli", "Rohit Sharma", "Steve Smith",
//            "Kane Williamson", "Ross Taylor"
//        )
//        // access the listView from xml file
//        var mListView = findViewById<ListView>(R.id.recipeList)
//        arrayAdapter = ArrayAdapter(this,
//            android.R.layout.simple_list_item_1, users)
//        mListView.adapter = arrayAdapter


    }
    @Preview(
        showBackground = true,
        showSystemUi = true,
        name = "Full Body preview"
    )
    @Composable
    fun MainBody()
    {
        NavMenu()
    }
}

