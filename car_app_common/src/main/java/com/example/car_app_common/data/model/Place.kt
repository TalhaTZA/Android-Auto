package com.example.car_app_common.data.model

import android.content.Intent
import android.net.Uri

data class Place(
    val id: Int,
    val name: String,
    val description: String,
    val latitude: Double,
    val longitude: Double
)

fun Place.toIntent(action: String): Intent {
    return Intent(action).apply {
        data = Uri.parse("geo:$latitude,$longitude")
    }
}