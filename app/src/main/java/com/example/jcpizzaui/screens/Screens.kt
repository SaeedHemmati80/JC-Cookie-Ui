package com.example.jcpizzaui.screens

sealed class Screens(val route: String) {
    data object Premium: Screens(route = "Premium")
    data object DetailsCookies: Screens(route = "DetailsCookies")
    data object DetailsOffers: Screens(route = "DetailsOffers")
    data object CookieSeeMore: Screens(route = "CookieSeeMore")
    data object OfferSeeMore: Screens(route = "OfferSeeMore")
}