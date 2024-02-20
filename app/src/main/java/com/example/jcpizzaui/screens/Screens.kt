package com.example.jcpizzaui.screens

sealed class Screens(val route: String) {
    data object Premium: Screens(route = "Premium")
    data object Details: Screens(route = "Details")
    data object SeeMore: Screens(route = "SeeMore")
}