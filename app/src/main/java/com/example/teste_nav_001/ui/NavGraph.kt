package com.example.teste_nav_001.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.teste_nav_001.*

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ROUTE_A,
        route = ROOT_ROUTE
    ) {

        rootGraph(navController = navController)

        routeBGraph(navController = navController)

    }
}

fun NavGraphBuilder.rootGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.ScreenContentA.route,
        route =  ROUTE_A
    ) {
        composable(
            route = Screen.ScreenContentA.route
        ) {
            ScreenContentA(navController = navController)
        }
        composable(
            route = Screen.ScreenContentB.route
        ) {
            ScreenContentB(navController = navController)
        }
        composable(
            route = Screen.ScreenContentC.route
        ) {
            ScreenContentC(navController = navController)
        }
    }
}

fun NavGraphBuilder.routeBGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.ScreenContentD.route,
        route = ROUTE_B
    ) {
        composable(
            route = Screen.ScreenContentD.route
        ) {
            ScreenContentD(navController = navController)
        }
        composable(
            route = Screen.ScreenContentE.route
        ) {
            ScreenContentE(navController = navController)
        }
    }
}