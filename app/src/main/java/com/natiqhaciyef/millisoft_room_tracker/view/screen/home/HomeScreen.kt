package com.natiqhaciyef.millisoft_room_tracker.view.screen.home

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.natiqhaciyef.millisoft_room_tracker.view.navigation.ScreenID

//@Preview
@Composable
fun HomeScreen(
    navController: NavController
){
    Button(onClick = {
        navController.navigate(ScreenID.DetailsScreen.name)
    }) {
        Text(text = "Go Details")
    }
}


