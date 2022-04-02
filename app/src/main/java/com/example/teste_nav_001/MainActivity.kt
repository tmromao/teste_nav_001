package com.example.teste_nav_001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.teste_nav_001.ui.MainScreen
import com.example.teste_nav_001.ui.ROUTE_B
import com.example.teste_nav_001.ui.Screen
import com.example.teste_nav_001.ui.SetupNavGraph
import com.example.teste_nav_001.ui.theme.Teste_nav_001Theme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Teste_nav_001Theme {

                navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //SetupNavGraph(navController = navController)
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun ScreenContentA(
    navController: NavController
) {

    var key by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Screen A",
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold
            )
            Button(onClick = {
                navController.navigate(route = Screen.ScreenContentB.route)
                //key = !key
                //println("clicked A")
            })
            {
                Text("Click me! to go to ScreenB")
            }
        }
    }
}

@Composable
fun ScreenContentB(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Column {
            Text("Screen B")
            Button(onClick = {
                navController.navigate(route = Screen.ScreenContentC.route) {
                    popUpTo(Screen.ScreenContentA.route)
                }
            }) {
                Text("Click me! to go to ScreenC")
            }
        }
    }
}

@Composable
fun ScreenContentC(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Column {
            Text("Screen C")
            Button(onClick = {
                navController.navigate(route = Screen.ScreenContentA.route) {
                    popUpTo(Screen.ScreenContentA.route)
                    //println("clicked C")
                }
            })
            {
                Text("Click me! to go to ScreenA")
            }

            Button(onClick = {
                navController.navigate(ROUTE_B) {

                    //println("clicked D")
                }
            })
            {
                Text("Click me! to go to ScreenD")
            }
        }
    }
}

@Composable
fun ScreenContentD(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Column {
            Text("Screen D")
            Button(onClick = {

                navController.navigate(route = Screen.ScreenContentE.route) {

                    //println("clicked D")
                }
            })
            {
                Text("Click me! to go to ScreenE")
            }
        }
    }
}

@Composable
fun ScreenContentE(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        //Text("Screen E")
        Column {
            Text("Screen E")
            Button(onClick = {

                navController.navigate(route = Screen.ScreenContentA.route) {

                    //println("clicked E")
                }

            })
            {
                Text("Click me! to go to navigate back Screen A")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Teste_nav_001Theme {
        ScreenContentA(navController = rememberNavController())
    }
}