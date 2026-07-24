package com.sginger.todo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.sginger.todo.ui.theme.TodoTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sginger.todo.ui.navigation.Greetings
import com.sginger.todo.ui.navigation.Home

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(innerPadding)
                }
            }
        }
    }
}

@Composable
fun App(innerPadding: PaddingValues) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable<Home> {
            Home(navController = navController)
        }
        composable<Greetings> {
            Greeting(navController = navController)
        }
    }
}

@Composable
fun Greeting(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Hello Android",
        )
        Button(
            onClick = {
                navController.navigate(Home)
            }
        ) {
            Text("To Home")
        }
    }
}


@Composable
fun Home(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Hello Home",
        )
        Button(
            onClick = {
                navController.navigate(Greetings)
            }
        ) {
            Text("To Greetings")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoTheme {
        Greeting(rememberNavController())
    }
}