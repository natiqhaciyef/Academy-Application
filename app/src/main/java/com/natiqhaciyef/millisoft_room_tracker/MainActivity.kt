package com.natiqhaciyef.millisoft_room_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.natiqhaciyef.millisoft_room_tracker.ui.theme.MilliSoftRoomTrackerTheme
import com.natiqhaciyef.millisoft_room_tracker.view.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MilliSoftRoomTrackerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
//        AppNavigation()
    }
}