package com.music.splash

import AnimatedSplashScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.music.theme.MusicTheme

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.music.ui.theme.MusicTheme() {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                SetUpNavGraph(navHostController = navController)
            }
        }
    }
}
sealed class Screen(val route:String){
    object Splash:Screen("splash_screen")
}

@Composable
fun SetUpNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Splash.route){
        composable( route = Screen.Splash.route ){
            AnimatedSplashScreen(navController = navHostController)}
    }
}