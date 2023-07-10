package com.example.car_app_common

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.lifecycle.DefaultLifecycleObserver
import com.example.car_app_common.screens.MainScreen

class HelloWorldSession : Session() , DefaultLifecycleObserver {
    override fun onCreateScreen(intent: Intent): Screen {
        return MainScreen(carContext)
    }
}