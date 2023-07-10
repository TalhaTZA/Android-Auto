package com.example.car_app_common.screens

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.CarIcon
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.car.app.sample.helloworld.car_app_common.R
import androidx.core.graphics.drawable.IconCompat
import com.example.car_app_common.data.PlacesRepository
import com.example.car_app_common.data.model.toIntent

class DetailScreen(carContext: CarContext, private val placeId: Int) : Screen(carContext) {

    override fun onGetTemplate(): Template {
        val place = PlacesRepository().getPlace(placeId)
            ?: return MessageTemplate.Builder("Place not found")
                .setHeaderAction(Action.BACK)
                .build()

        val navigateAction = Action.Builder()
            .setTitle("Navigate")
            .setIcon(
                CarIcon.Builder(
                    IconCompat.createWithResource(
                        carContext,
                        R.drawable.baseline_navigation_24
                    )
                ).build()
            )
            .setOnClickListener { carContext.startCarApp(place.toIntent(CarContext.ACTION_NAVIGATE)) }
            .build()

        return PaneTemplate.Builder(
            Pane.Builder()
                .addAction(navigateAction)
                .addRow(
                    Row.Builder()
                        .setTitle("Coordinates")
                        .addText("${place.latitude}, ${place.longitude}")
                        .build()
                ).addRow(
                    Row.Builder()
                        .setTitle("Description")
                        .addText(place.description)
                        .build()
                ).build()
        )
            .setTitle(place.name)
            .setHeaderAction(Action.BACK)
            .build()
    }
}