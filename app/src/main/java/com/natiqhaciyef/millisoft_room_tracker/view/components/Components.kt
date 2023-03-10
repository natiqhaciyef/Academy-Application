package com.natiqhaciyef.millisoft_room_tracker.view.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.natiqhaciyef.millisoft_room_tracker.R
import com.natiqhaciyef.millisoft_room_tracker.data.model.NavItemModel
import com.natiqhaciyef.millisoft_room_tracker.data.util.InstructorList
import com.natiqhaciyef.millisoft_room_tracker.ui.theme.PurpleExtraDark
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

@Composable
fun BottomShadow(alpha: Float = 0.1f, height: Dp = 8.dp,
                 padding: Dp = 0.dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .padding(horizontal = padding)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = alpha),
                        Color.Transparent,
                    )
                )
            )
    )
}

@Composable
fun BottomShadow(modifier: Modifier) {
    Box(
        modifier = modifier
    )
}

@Composable
fun NavBar(
    selectedIndex: MutableState<Int>,
    list: MutableList<NavItemModel> = mutableListOf(
        NavItemModel(image = R.drawable.home_icon, title = "Home"),
        NavItemModel(image = R.drawable.meeting_room_icon, title = "Rooms"),
        NavItemModel(image = R.drawable.courses_icon, title = "Courses"),
        NavItemModel(image = R.drawable.account_circle_icon, title = "User")
    )
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            list.forEachIndexed { index, icon ->
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(12f)
                        .clickable { selectedIndex.value = index },
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        modifier = if (selectedIndex.value == index)
                            Modifier.offset(y = (-8).dp)
                        else
                            Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .background(
                                    if (selectedIndex.value == index) MaterialTheme.colors.primary
                                    else Color.Transparent,
                                    shape = CircleShape
                                )
                                .size(45.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = icon.image),
                                contentDescription = "content",
                                modifier = Modifier.size(25.dp),
                                tint = if (selectedIndex.value == index) Color.White else Color.Gray
                            )
                        }
                        AnimatedVisibility(visible = (selectedIndex.value == index)) {
                            Text(
                                text = icon.title,
                                modifier = Modifier,
                                color = Color.Black,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}



@Preview
@ExperimentalPagerApi
@Composable
fun CustomViewPager() {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = InstructorList.instructors.size
    )

    LaunchedEffect(key1 = Unit) {
        while (true) {
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .padding(horizontal = 40.dp)
    ) { page ->

        Card(
            modifier = Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                .fillMaxWidth()
                .height(295.dp)
                .padding(horizontal = 40.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            val item = InstructorList.instructors[page]
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .background(color = PurpleExtraDark)
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(230.dp),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = item.image),
                        contentDescription = "Instructor",
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = item.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = item.field,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }
    }
}