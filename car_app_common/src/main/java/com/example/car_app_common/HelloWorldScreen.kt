package com.example.car_app_common

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*

class HelloWorldScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val row = Row.Builder().setTitle("Hello AndroidX!").build()
        return PaneTemplate.Builder(Pane.Builder().addRow(row).build())
            .setHeaderAction(Action.APP_ICON)
            .build()
    }
}