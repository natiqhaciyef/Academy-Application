package com.natiqhaciyef.millisoft_room_tracker.view.screen.home

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import com.natiqhaciyef.millisoft_room_tracker.ui.theme.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.natiqhaciyef.millisoft_room_tracker.R
import com.natiqhaciyef.millisoft_room_tracker.view.navigation.ScreenID

//@Preview
@Composable
fun HomeScreen(
    navController: NavController
) {
    HomeTopView {
        HomeBodyView()
        HomeBottomView()
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

@Preview
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
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.android_development),
                            contentDescription = "Android Development",
                            modifier = Modifier
                                .padding(start = 35.dp, end = 35.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Android Development",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = White
                        )
                    }

                }

                Spacer(modifier = Modifier.width(20.dp))

                Card(
                    modifier = Modifier
                        .size(160.dp),
                    backgroundColor = Color.Gray,
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.java_development),
                            contentDescription = "Java Development",
                            modifier = Modifier
                                .padding(start = 35.dp, end = 35.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Java Development",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = White
                        )
                    }

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
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.frontend),
                            contentDescription = "FrontEnd Development",
                            modifier = Modifier
                                .padding(start = 35.dp, end = 35.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Front-End Development",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = White
                        )
                    }

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
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun HomeBottomView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = "Instructors",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Black
        )
        Spacer(modifier = Modifier.height(22.dp))

        HorizontalPager(pageCount = 3) {

        }
        Spacer(modifier = Modifier.height(75.dp))
    }
}