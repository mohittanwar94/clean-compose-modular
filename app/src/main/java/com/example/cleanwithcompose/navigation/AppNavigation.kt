package com.example.cleanwithcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.commentlist.navigation.commentListScreen

/*define App Navigation for each Module with backStack control*/
@Composable
fun AppNavigation(
    modifier: Modifier,
    navHostController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        commentListScreen(onBackClick = navHostController::popBackStackOrIgnore)
    }

}

fun NavController.popBackStackOrIgnore() {
    if (currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
        popBackStack()
    }
}