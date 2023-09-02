package com.ezriouil.freetoplay.utils

sealed class ManageScreen(val route: String) {
    object SingInScreen : ManageScreen(route = "SING_IN_SCREEN")
    object SingUpScreen : ManageScreen(route = "SING_UP_SCREEN")
    object HomeScreen : ManageScreen(route = "HOME")
    object DetailScreen : ManageScreen(route = "DETAIL_SCREEN")
}
