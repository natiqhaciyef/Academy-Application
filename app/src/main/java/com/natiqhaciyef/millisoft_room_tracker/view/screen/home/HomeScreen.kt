package com.natiqhaciyef.millisoft_room_tracker.view.screen.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.natiqhaciyef.millisoft_room_tracker.ui.theme.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.natiqhaciyef.millisoft_room_tracker.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import androidx.compose.foundation.pager.rememberPagerState
import com.google.accompanist.pager.HorizontalPager
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.util.lerp
import com.airbnb.lottie.utils.MiscUtils.lerp
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.natiqhaciyef.millisoft_room_tracker.data.model.UserModel
import com.natiqhaciyef.millisoft_room_tracker.data.util.InstructorList
import com.natiqhaciyef.millisoft_room_tracker.view.components.CustomViewPager
import kotlin.math.absoluteValue


//@Preview
@Composable
fun HomeScreen(
    navController: NavController
) {
    HomeView {
        HomeTopView()
        HomeBodyView()
        HomeBottomView()
    }
}

@Preview
@Composable
fun HomeView(content: @Composable () -> Unit = { }) {
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
fun HomeTopView(user: UserModel =
                    UserModel(0,"Natiq","name.haciyef@gmail.com")
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(40.dp))

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
            Spacer(modifier = Modifier.height(25.dp))

            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "Courses",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Black
            )

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
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.c_sharp_development),
                            contentDescription = "C# Development",
                            modifier = Modifier
                                .padding(start = 35.dp, end = 35.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "C# Development",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
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
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Black
        )
        Spacer(modifier = Modifier.height(20.dp))

        CustomViewPager()

        Spacer(modifier = Modifier.height(85.dp))
    }
}
