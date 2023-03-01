package com.natiqhaciyef.millisoft_room_tracker.view.navigation

enum class ScreenID {
    RegisterScreen,
    LoginScreen,
    ForgotPasswordScreen,
    HomeScreen,
    DetailsScreen,
    RoomTrackingScreen,
    CoursesScreen,
    UserProfileScreen;

    fun routeBetweenScreens(route: String?) = when(route){
        RegisterScreen.name -> RegisterScreen
        LoginScreen.name -> LoginScreen
        ForgotPasswordScreen.name -> ForgotPasswordScreen
        HomeScreen.name -> HomeScreen
        RoomTrackingScreen.name -> RoomTrackingScreen
        CoursesScreen.name -> CoursesScreen
        UserProfileScreen.name -> UserProfileScreen
        null -> HomeScreen
        else -> throw IllegalArgumentException("Route $route is not required")
    }
}