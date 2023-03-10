package com.natiqhaciyef.millisoft_room_tracker.data.util

import com.natiqhaciyef.millisoft_room_tracker.R
import com.natiqhaciyef.millisoft_room_tracker.data.model.InstructorModel

object InstructorList {
    val instructors = listOf(
        InstructorModel(name = "Natiq Hacıyev", field = "Mobile Developer",image = R.drawable.natiq),
        InstructorModel(name = "Uğur Kərimov", field = "Back-End Developer",image = R.drawable.ugur),
        InstructorModel(name = "Rüfət Hüseynov", field = "Back-End Developer",image = R.drawable.rufet),
        InstructorModel(name = "Ramin Mikaylov", field = "Front-End Developer",image = R.drawable.ramin),
    )
}