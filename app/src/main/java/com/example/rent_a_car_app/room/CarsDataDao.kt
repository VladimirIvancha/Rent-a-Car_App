package com.example.rent_a_car_app.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface CarsDataDao {

    @Query("select * from CarsData")
    fun getAll(): LiveData<List<CarsData>>

    @Query("select * from CarsData where  id = :carsId")
    suspend fun getById(carsId: Int): CarsData

    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: CarsData)


}