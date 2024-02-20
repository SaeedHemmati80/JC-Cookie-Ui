package com.example.jcpizzaui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jcpizzaui.models.CookiesData
import com.example.jcpizzaui.screens.DetailsScreen
import com.example.jcpizzaui.screens.PremiumScreen
import com.example.jcpizzaui.screens.Screens
import com.example.jcpizzaui.screens.SeeMoreScreen

@Composable
fun NavGraph(cookiesList: List<CookiesData>) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Premium.route) {

        composable(Screens.Premium.route) {
            PremiumScreen(navController = navController, cookiesList)
        }

        composable(Screens.Details.route + "?item={index}",
            arguments = listOf(navArgument("index") {
                type = NavType.IntType
            }
            )
        ) {
            DetailsScreen(
                cookiesList = cookiesList,
                index = it.arguments?.getInt("index")
            )
        }

        composable(Screens.SeeMore.route)
         {
            SeeMoreScreen(
                navController = navController,
                cookiesList = cookiesList
            )
        }
    }
}