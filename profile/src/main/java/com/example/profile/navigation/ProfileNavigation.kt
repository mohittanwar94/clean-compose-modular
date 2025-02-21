package com.example.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.profile.ui.ProfileScreenRoute

const val name = "name"
const val postId = "postId"
const val comment = "comment"
const val PROFILE_NAVIGATION_WITH_ARGUMENTS =
    "profileScreen/{postId}/{name}/{comment}"

/*use for comment navigation extension function*/
fun NavController.navigateToProfile(postId: Int, name: String, comment: String) {
    val routeProfileWithArguments = "profileScreen/$postId/$name/$comment"
    navigate(route = routeProfileWithArguments)
}

/*create Graph entry through NavGraph Builder*/
fun NavGraphBuilder.profileScreen(onBackClick: () -> Unit) {
    composable(
        route = PROFILE_NAVIGATION_WITH_ARGUMENTS, arguments = listOf(navArgument(postId) {
            type = NavType.StringType
            nullable = true
        },
            navArgument(name) {
                type = NavType.StringType
                nullable = true
            },
            navArgument(comment) {
                type = NavType.StringType
                nullable = true
            })
    ) { backStackEntry ->
        val postId = backStackEntry.arguments?.getString(postId)
        val name = backStackEntry.arguments?.getString(name)
        val comment = backStackEntry.arguments?.getString(comment)
        ProfileScreenRoute(
            postId, name, comment,
            onBackClick = onBackClick
        )
    }

}