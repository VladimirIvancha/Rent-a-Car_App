package com.example.rent_a_car_app

import com.example.rent_a_car_app.room.CarsData
import com.example.rent_a_car_app.room.CarsDataDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CarsRepository(private val dao: CarsDataDao) {

    private val list = dao.getAll()

    fun getAll() = list

    suspend fun insert(vararg cars: CarsData){
        withContext(Dispatchers.IO){
            cars.forEach {
                dao.insert(it)
            }
        }
    }

    suspend fun getById(id: Int): CarsData {
        return withContext(Dispatchers.IO) {
            return@withContext dao.getById(id)
        }
    }

}