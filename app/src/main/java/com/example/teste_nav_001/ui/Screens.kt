package com.example.teste_nav_001.ui

const val ROOT_ROUTE = "root"
const val ROUTE_B = "rootB"
const val ROUTE_A = "rootA"

sealed class Screen (val route:String){
    object ScreenContentA : Screen(route = "ScreenContent_A")
    object ScreenContentB : Screen(route = "ScreenContent_B")
    object ScreenContentC : Screen(route = "ScreenContent_C")
    object ScreenContentD : Screen(route = "ScreenContent_D")
    object ScreenContentE : Screen(route = "ScreenContent_E")
}