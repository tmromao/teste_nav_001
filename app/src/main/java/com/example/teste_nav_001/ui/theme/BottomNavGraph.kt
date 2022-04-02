package com.example.teste_nav_001.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.teste_nav_001.ScreenContentA
import com.example.teste_nav_001.ui.Screen

@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.ScreenContentA.route){
        composable(route = Screen.ScreenContentA.route){
            ScreenContentA(navController)
        }
    }
}