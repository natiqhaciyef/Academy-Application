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
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.natiqhaciyef.millisoft_room_tracker.R
import com.natiqhaciyef.millisoft_room_tracker.data.util.FontList
import com.natiqhaciyef.millisoft_room_tracker.ui.theme.*
import com.natiqhaciyef.millisoft_room_tracker.view.components.BottomShadow
import com.natiqhaciyef.millisoft_room_tracker.view.navigation.ScreenID


private lateinit var auth: FirebaseAuth
//@Preview
@Composable
fun RegisterScreen(
    navController: NavController,
) {
    auth = Firebase.auth
    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val context = LocalContext.current
    println(1)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        RegisterTopScreen()
        RegisterMainPart(username, email, password, navController, auth)
    }
}

//@Preview
@Composable
fun RegisterMainPart(
    username: MutableState<String> = mutableStateOf(""),
    email: MutableState<String> = mutableStateOf(""),
    password: MutableState<String> = mutableStateOf(""),
    navController: NavController,
    auth: FirebaseAuth
) {
    var passwordVisible by remember { mutableStateOf(false) }
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
            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = username.value,
                onValueChange = {
                    username.value = it
                },
                singleLine = true,
                placeholder = {
                    Text(text = "Username")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Username"
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

            Spacer(modifier = Modifier.height(8.dp))

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

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                singleLine = true,
                placeholder = {
                    Text(text = "Password")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password"
                    )
                },
                visualTransformation =
                if (passwordVisible)
                    VisualTransformation.None
                else PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(horizontal = 20.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    trailingIconColor = Color.Black
                ),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle.Default.copy(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(
                        modifier = Modifier.padding(end = 15.dp),
                        onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                }
            )

            BottomShadow(padding = 23.dp)

            Spacer(modifier = Modifier.height(25.dp))

            val context = LocalContext.current

            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(180.dp),
                onClick = {
                    register(
                        context = context,
                        email = email.value,
                        password = password.value,
                        navController = navController,
                        auth = auth
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Yellow
                )
            ) {
                Text(
                    text = "Register",
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

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Do you have an account ?",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(ScreenID.LoginScreen.name)
                        },
                    text = "Sign in",
                    color = Yellow,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }
}


@Composable
fun RegisterTopScreen() {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.registration_animation)
    )
    Spacer(modifier = Modifier.height(20.dp))
    LottieAnimation(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        composition = composition
    )
    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Registration",
        fontSize = 25.sp,
        color = Color.Black,
        fontFamily = FontList.fontFamily,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(30.dp))
}


fun register(
    context: Context,
    email: String,
    password: String,
    navController: NavController,
    auth:FirebaseAuth
) {
    auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
        navController.navigate(ScreenID.HomeScreen.name)
    }.addOnFailureListener {
        // error message for user
        Toast.makeText(context, "Something went wrong. Try it again", Toast.LENGTH_SHORT).show()
    }
}