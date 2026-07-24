package com.sginger.todo.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sginger.todo.ui.navigation.Greetings
import com.sginger.todo.ui.navigation.Home

@Composable
fun TodoApp(innerPadding: PaddingValues) {
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