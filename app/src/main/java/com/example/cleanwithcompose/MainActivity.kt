package com.example.cleanwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.cleanwithcompose.navigation.AppNavigation
import com.example.commentlist.navigation.COMMENT_LIST_NAVIGATION
import com.example.coreandroid.theme.CleanWithComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanWithComposeTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    AppNavigation(
                        navHostController = navController,
                        modifier = Modifier.fillMaxSize(),
                        startDestination = COMMENT_LIST_NAVIGATION
                    )
                }
            }
        }
    }
}