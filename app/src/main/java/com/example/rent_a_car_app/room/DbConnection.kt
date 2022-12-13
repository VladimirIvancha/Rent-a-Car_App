package com.example.rent_a_car_app.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CarsData::class], version = 1)
abstract class DbConnection : RoomDatabase() {
    abstract fun entityDao(): CarsDataDao
}