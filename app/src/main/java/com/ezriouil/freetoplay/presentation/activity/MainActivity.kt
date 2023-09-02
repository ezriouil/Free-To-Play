package com.ezriouil.freetoplay.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.ezriouil.freetoplay.presentation.screen.Index
import com.ezriouil.freetoplay.presentation.theme.FreeToPlayTheme
import com.ezriouil.freetoplay.presentation.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Splash Screen
        //khass hta tkon value dyal state li f view model true 3ad kay hide splash screen
        //installSplashScreen().setKeepOnScreenCondition{viewModel.splashScreenVisible.value}
        setContent {
            val navController = rememberNavController()
            val scaffoldState = rememberScaffoldState()
            val coroutineScope = rememberCoroutineScope()
            val games by viewModel.games.collectAsState()
            FreeToPlayTheme {
                Index(
                    scaffoldState = scaffoldState,
                    navHostController = navController,
                    onClickSearch = {},
                    onClickDrawer = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    },
                    games = games,
                    coroutineScope = coroutineScope
                )
            }
        }
    }
}