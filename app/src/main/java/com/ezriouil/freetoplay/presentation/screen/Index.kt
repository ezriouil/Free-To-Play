package com.ezriouil.freetoplay.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ezriouil.freetoplay.R
import com.ezriouil.freetoplay.domain.model.Game
import com.ezriouil.freetoplay.presentation.component.NavigationDrawer
import com.ezriouil.freetoplay.presentation.component.NavigationDrawerItem
import com.ezriouil.freetoplay.utils.GAME_ID
import com.ezriouil.freetoplay.utils.ManageScreen
import com.ezriouil.freetoplay.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Index(
    scaffoldState: ScaffoldState,
    navHostController: NavHostController,
    onClickSearch: () -> Unit,
    onClickDrawer: () -> Unit,
    games: Resource<List<Game>>,
    coroutineScope: CoroutineScope
) {
    Scaffold(scaffoldState = scaffoldState,
        drawerShape = RectangleShape,
        drawerContent = {
            NavigationDrawer(header = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(
                            height = 180.dp
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_free_to_play_splash),
                        contentDescription = null
                    )
                }
            }) {
                NavigationDrawerItem(modifier = Modifier
                    .requiredHeight(50.dp)
                    .padding(5.dp),
                    text = "Aaa",
                    icon = painterResource(id = R.drawable.ic_warning),
                    onClick = {
                        navHostController.navigate(ManageScreen.HomeScreen.route)
                        coroutineScope.launch { scaffoldState.drawerState.close() }
                    })
                NavigationDrawerItem(modifier = Modifier
                    .requiredHeight(50.dp)
                    .padding(5.dp),
                    text = "Aaa",
                    icon = painterResource(id = R.drawable.ic_close_button),
                    onClick = {
                        navHostController.navigate(ManageScreen.HomeScreen.route)
                        coroutineScope.launch { scaffoldState.drawerState.close() }
                    })
            }
        }) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navHostController,
            startDestination = ManageScreen.SingInScreen.route
        ) {
            //SingInScreen
            composable(route = ManageScreen.SingUpScreen.route) {
                SingUp(navHostController = navHostController)
            }

            //SingUpScreen
            composable(route = ManageScreen.SingInScreen.route) {
                SingIn(navHostController = navHostController)
            }

            //HomeScreen
            composable(route = ManageScreen.HomeScreen.route) {
                Home(
                    onClickDrawer = onClickDrawer,
                    onClickSearch = onClickSearch,
                    games = games,
                    onGameClick = { gameId ->
                        navHostController.navigate(ManageScreen.DetailScreen.route + "/" + gameId)
                    }
                )
            }
            //DetailScreen
            composable(route = ManageScreen.DetailScreen.route + "/{$GAME_ID}") {
                Detail()
            }
        }
    }
}