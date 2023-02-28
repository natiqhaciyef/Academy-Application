package com.natiqhaciyef.millisoft_room_tracker.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.natiqhaciyef.millisoft_room_tracker.view.screen.home.HomeScreen
import com.natiqhaciyef.millisoft_room_tracker.view.screen.registration.ForgotPasswordScreen
import com.natiqhaciyef.millisoft_room_tracker.view.screen.registration.LoginScreen
import com.natiqhaciyef.millisoft_room_tracker.view.screen.registration.RegisterScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenID.RegisterScreen.name){
        composable(ScreenID.RegisterScreen.name){
            RegisterScreen(navController)
        }

        composable(ScreenID.LoginScreen.name){
            LoginScreen(navController)
        }

        composable(ScreenID.ForgotPasswordScreen.name){
            ForgotPasswordScreen()
        }

        composable(ScreenID.HomeScreen.name){
            HomeScreen()
        }

        composable(ScreenID.RoomTrackingScreen.name){

        }

        composable(ScreenID.CoursesScreen.name){

        }

        composable(ScreenID.UserProfileScreen.name){

        }

//        composable(
//            route = "${ScreenID.HomeScreen.name}/{id}/{name}",
//            arguments = listOf(
//                navArgument(name = "id"){
//                    type = NavType.IntType
//                },
//                navArgument(name = "name"){
//                    type = NavType.StringType
//                }
//            )
//        ){
//            val id = remember{
//                it.arguments?.getInt("id")
//            }
//
//            val name = remember{
//                it.arguments?.getString("name")
//            }
//        }

    }
}