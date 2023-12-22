package com.bangkit.pregai.utils

import com.vaibhav.healthify.data.models.OnBoarding
import pregai.R
import java.util.*

val onBoardingList = listOf(
    OnBoarding(
        id = 0,
        anim = R.raw.hello,
        title = "Welcome!",
        subtitle = "Stay fit and improve your productivity\n" +
            "with Healthify"
    ),
    OnBoarding(
        id = 1,
        anim = R.raw.water,
        title = "Stay hydrated",
        subtitle = "Healthify helps you track your water\n" +
            "intake and reminds you to drink water"
    ),
    OnBoarding(
        id = 2,
        anim = R.raw.sleep,
        title = "Maintain Good Sleep",
        subtitle = "Healthify tracks your daily sleep\n" +
            "and helps you maintain a good sleep cycle"
    ),
    OnBoarding(
        id = 3,
        anim = R.raw.leaderboard,
        title = "Earn XP as you go",
        subtitle = "Earn XP when you drink water or record sleep. Make your way up to the leaders"
    )
)

