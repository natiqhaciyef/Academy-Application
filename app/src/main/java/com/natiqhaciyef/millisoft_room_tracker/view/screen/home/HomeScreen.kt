package com.natiqhaciyef.millisoft_room_tracker.view.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import com.natiqhaciyef.millisoft_room_tracker.ui.theme.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.natiqhaciyef.millisoft_room_tracker.view.navigation.ScreenID

//@Preview
@Composable
fun HomeScreen(
    navController: NavController
){

}

@Preview
@Composable
fun HomeTopView(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .background(PurpleExtraDark)
    ) {

    }
}


