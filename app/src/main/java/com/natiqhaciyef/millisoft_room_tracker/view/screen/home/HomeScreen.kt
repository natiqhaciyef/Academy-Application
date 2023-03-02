package com.natiqhaciyef.millisoft_room_tracker.view.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import com.natiqhaciyef.millisoft_room_tracker.ui.theme.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.natiqhaciyef.millisoft_room_tracker.view.navigation.ScreenID

//@Preview
@Composable
fun HomeScreen(
    navController: NavController
) {

}

@Preview
@Composable
fun HomeTopView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleExtraDark)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .background(PurpleExtraDark)
        ) {

        }

        Card(
            modifier = Modifier
                .fillMaxSize(),
            contentColor = White,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier
                            .size(190.dp)
                            .padding(start = 20.dp, end = 20.dp, top = 40.dp),
                        backgroundColor = Color.Gray
                    ) {

                    }

                    Card(
                        modifier = Modifier
                            .size(190.dp)
                            .padding(start = 20.dp, end = 20.dp, top = 40.dp),
                        backgroundColor = Color.Gray
                    ) {

                    }
                }
            }
        }
    }
}


