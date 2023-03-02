package com.natiqhaciyef.millisoft_room_tracker.view.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
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
    HomeTopView {
        HomeBodyView()
    }
}

@Preview
@Composable
fun HomeTopView(content: @Composable () -> Unit = { }) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleExtraDark)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}

@Composable
fun HomeBodyView() {
    Spacer(modifier = Modifier.height(280.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        contentColor = White,
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size(160.dp),
                    backgroundColor = Color.Gray,
                    shape = RoundedCornerShape(15.dp)
                ) {

                }

                Spacer(modifier = Modifier.width(20.dp))

                Card(
                    modifier = Modifier
                        .size(160.dp),
                    backgroundColor = Color.Gray,
                    shape = RoundedCornerShape(15.dp)
                ) {

                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size(160.dp),
                    backgroundColor = Color.Gray,
                    shape = RoundedCornerShape(15.dp)
                ) {

                }

                Spacer(modifier = Modifier.width(20.dp))

                Card(
                    modifier = Modifier
                        .size(160.dp),
                    backgroundColor = Color.Gray,
                    shape = RoundedCornerShape(15.dp)
                ) {

                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size(160.dp),
                    backgroundColor = Color.Gray,
                    shape = RoundedCornerShape(15.dp)
                ) {

                }

                Spacer(modifier = Modifier.width(20.dp))

                Card(
                    modifier = Modifier
                        .size(160.dp),
                    backgroundColor = Color.Gray,
                    shape = RoundedCornerShape(15.dp)
                ) {

                }
            }

            Spacer(modifier = Modifier.height(75.dp))
        }
    }
}
