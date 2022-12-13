package com.example.rent_a_car_app.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.rent_a_car_app.CarsRepository
import com.example.rent_a_car_app.room.CarsData
import com.example.rent_a_car_app.room.DbConnection
import kotlinx.coroutines.launch

class CarsViewModel(application: Application) : AndroidViewModel(application) {

    private var cars: LiveData<List<CarsData>>? = null

    var selectedCars: MutableLiveData<CarsData> = MutableLiveData()

    private val repository: CarsRepository
    init {
        val dao = Room.databaseBuilder(application.applicationContext, DbConnection::class.java, "db")
            .build()
            .entityDao()
        repository = CarsRepository(dao)
    }


    fun getAll(): LiveData<List<CarsData>>? {
        if (cars == null){
            cars = repository.getAll()
        }
        return cars
    }

    fun insert(vararg carsData: CarsData){
        viewModelScope.launch {
            repository.insert(*carsData)
        }
    }

    fun getById(id: Int) {
        viewModelScope.launch {
            val cars = repository.getById(id)
            selectedCars.value = cars
        }
    }
}