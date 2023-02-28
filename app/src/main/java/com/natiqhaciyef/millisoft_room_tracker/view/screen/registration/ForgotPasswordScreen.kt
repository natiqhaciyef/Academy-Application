package com.natiqhaciyef.millisoft_room_tracker.view.screen.registration

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.natiqhaciyef.millisoft_room_tracker.R
import com.natiqhaciyef.millisoft_room_tracker.data.util.FontList
import com.natiqhaciyef.millisoft_room_tracker.ui.theme.PurpleExtraDark
import com.natiqhaciyef.millisoft_room_tracker.ui.theme.Yellow
import com.natiqhaciyef.millisoft_room_tracker.view.components.BottomShadow

private lateinit var auth: FirebaseAuth

@Preview
@Composable
fun ForgotPasswordScreen(){
    auth = Firebase.auth
    val email = remember{ mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        ForgotPasswordTopScreen()
        ForgotPasswordMainPart(email)
    }
}

@Preview
@Composable
fun ForgotPasswordMainPart(
    email: MutableState<String> = mutableStateOf(""),
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(),
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        backgroundColor = PurpleExtraDark
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                placeholder = {
                    Text(text = "Email")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(horizontal = 20.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                ),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle.Default.copy(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            BottomShadow(padding = 23.dp)

            Spacer(modifier = Modifier.height(23.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
                    .clickable {

                    },
                text = "Please check your email, we will send the reset password link. If it is not show, check spam messages box.",
                color = Yellow,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
            )

            Spacer(modifier = Modifier.height(30.dp))

            val context = LocalContext.current
            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(180.dp),
                onClick = {
                    resetPassword(
                        email = email.value,
                        context = context
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Yellow
                )
            ) {
                Text(
                    text = "Send",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            BottomShadow(
                modifier = Modifier
                    .width(165.dp)
                    .height(8.dp)
                    .padding(horizontal = 0.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.1f),
                                Color.Transparent,
                            )
                        )
                    )
            )
        }
    }
}


@Composable
fun ForgotPasswordTopScreen() {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.forgot_password_animation)
    )
    Spacer(modifier = Modifier.height(50.dp))
    LottieAnimation(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        composition = composition
    )
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Forgot Password",
        fontSize = 25.sp,
        color = Color.Black,
        fontFamily = FontList.fontFamily,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(30.dp))
}


fun resetPassword(email: String, context: Context) {
    auth.sendPasswordResetEmail(email).addOnSuccessListener {
//        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }.addOnFailureListener {
        // error message for user
        Toast.makeText(context, "Something went wrong. Try it again", Toast.LENGTH_SHORT).show()
    }
}