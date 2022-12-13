package com.example.rent_a_car_app.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CarsData(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    var price: Int,
    var description: String,
    val img: String,
    var favorite: Boolean
)
