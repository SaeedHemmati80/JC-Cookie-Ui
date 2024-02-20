package com.example.jcpizzaui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jcpizzaui.models.CookiesData
import com.example.jcpizzaui.screens.CookiesSeeMoreScreen
import com.example.jcpizzaui.screens.DetailsCookiesScreen
import com.example.jcpizzaui.screens.DetailsOffersScreen
import com.example.jcpizzaui.screens.OfferSeeMoreScreen
import com.example.jcpizzaui.screens.PremiumScreen
import com.example.jcpizzaui.screens.Screens

@Composable
fun NavGraph(cookiesList: List<CookiesData>, cookieOffersList: List<CookiesData>) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Premium.route) {

        composable(Screens.Premium.route) {
            PremiumScreen(navController = navController, cookiesList, cookieOffersList)
        }

        composable(Screens.DetailsCookies.route + "?item={index}",
            arguments = listOf(navArgument("index") {
                type = NavType.IntType
            }
            )
        ) {
            DetailsCookiesScreen(
                cookiesList = cookiesList,
                item = it.arguments?.getInt("index")
            )
        }

        composable(Screens.DetailsOffers.route + "?item={index}",
            arguments = listOf(navArgument("index") {
                type = NavType.IntType
            }
            )
        ) {
            DetailsOffersScreen(
                cookieOffersList = cookieOffersList,
                item = it.arguments?.getInt("index")
            )
        }

        composable(Screens.CookieSeeMore.route)
         {
            CookiesSeeMoreScreen(
                navController = navController,
                cookiesList = cookiesList
            )
        }

        composable(Screens.OfferSeeMore.route)
        {
            OfferSeeMoreScreen(
                navController = navController,
                cookieOffersList = cookieOffersList
            )
        }
    }
}