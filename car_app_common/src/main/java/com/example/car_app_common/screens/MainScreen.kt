package com.example.car_app_common.screens

import android.text.Spannable
import android.text.SpannableString
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*
import com.example.car_app_common.data.PlacesRepository

class MainScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val placesRepository = PlacesRepository()
        val itemListBuilder = ItemList.Builder()
            .setNoItemsMessage("No places to show")

        placesRepository.getPlaces()
            .forEach {
                itemListBuilder.addItem(
                    Row.Builder()
                        .setTitle(it.name)
                        .addText(SpannableString(" ").apply {
                            setSpan(
                                DistanceSpan.create(
                                    Distance.create(Math.random() * 100, Distance.UNIT_KILOMETERS)
                                ), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                            )
                        })
                        .setOnClickListener { screenManager.push(DetailScreen(carContext, it.id)) }
                        .setMetadata(
                            Metadata.Builder()
                                .setPlace(
                                    Place.Builder(CarLocation.create(it.latitude, it.longitude))
                                        .setMarker(PlaceMarker.Builder().build())
                                        .build()
                                )
                                .build()
                        ).build()
                )
            }

        return PlaceListMapTemplate.Builder()
            .setTitle("Places")
            .setItemList(itemListBuilder.build())
            .build()
    }
}