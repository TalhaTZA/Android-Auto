package com.example.car_app_common.data

import com.example.car_app_common.data.model.Place


val PLACES = listOf(
    Place(
        0,
        "Brandenburg Gate",
        "The Brandenburg Gate is an 18th-century neoclassical monument in Berlin, built on the orders of Prussian king Frederick William II",
        52.5162778,
        13.3751292,
    ),
    Place(
        1,
        "The Berlin Wall",
        "The Berlin Wall was a guarded concrete barrier that encircled West Berlin of the Federal Republic of Germany (FRG) from 1961 to 1989, separating it from East Berlin and the German Democratic Republic. Construction of the Berlin Wall was commenced by the government of the GDR on 13 August 1961.",
        52.5071847,
        13.3809312
    ),
)

class PlacesRepository {
    fun getPlaces(): List<Place> {
        return PLACES
    }

    fun getPlace(placeId: Int): Place? {
        return PLACES.find { it.id == placeId }
    }
}