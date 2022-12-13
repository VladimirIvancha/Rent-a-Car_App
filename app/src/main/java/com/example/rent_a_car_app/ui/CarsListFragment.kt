package com.example.rent_a_car_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.rent_a_car_app.CarsListAdapter
import com.example.rent_a_car_app.R
import com.example.rent_a_car_app.data.TeslaCars
import com.example.rent_a_car_app.data.TeslaCarsList
import com.example.rent_a_car_app.databinding.FragmentSecondBinding
import com.example.rent_a_car_app.room.CarsData

class CarsListFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private lateinit var viewModel: CarsViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity())[CarsViewModel::class.java]
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CarsListAdapter()
        adapter.itemClick {
            val bundle = Bundle()
            bundle.putInt("ID", it.id)
            Navigation.findNavController(binding.root).navigate(
                R.id.action_SecondFragment_to_carsAboutFragment,
                bundle
            )
        }
        viewModel.getAll()?.observe(requireActivity()) {

            if (it.isEmpty()) {
                val list = initCarsList()
                list.forEach { cars ->
                    viewModel.insert(cars)
                }
            }

            adapter.items = it
        }

        binding.carsRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    var list = TeslaCarsList.teslaCarsList

    private fun initCarsList(): List<CarsData> {

        val result = arrayListOf<CarsData>()

        for (i in 0..8) {
            result.add(
                CarsData(
                    i,
                    list[i].name,
                    list[i].price,
                    list[i].description,
                    list[i].img,
                    false
                )
            )
        }
        return result
    }
}