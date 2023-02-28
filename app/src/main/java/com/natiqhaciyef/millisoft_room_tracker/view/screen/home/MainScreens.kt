package com.natiqhaciyef.millisoft_room_tracker.view.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.natiqhaciyef.millisoft_room_tracker.R
import com.natiqhaciyef.millisoft_room_tracker.view.components.NavBar


//@Preview
@Composable
fun MainScreens(){
    val selectedIndex = remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavBar(selectedIndex)
        }
    ) {
        it.calculateBottomPadding()

        when(selectedIndex.value){
            0 -> { HomeScreen() }
            1 -> { RoomTrackingScreen() }
            2 -> { CourseScreen() }
            3 -> { UserProfileScreen() }
        }
    }
}
