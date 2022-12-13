package com.example.rent_a_car_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.rent_a_car_app.R
import com.example.rent_a_car_app.databinding.FragmentCarsAboutBinding
import com.squareup.picasso.Picasso

class CarsAboutFragment : Fragment() {

    lateinit var binding: FragmentCarsAboutBinding
    lateinit var viewModel: CarsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCarsAboutBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity())[CarsViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt("ID")
        if (id != -1){
            id?.let {
                viewModel.getById(id)
            }
        }

        viewModel.selectedCars.observe(requireActivity()){
            if (it != null){
                binding.cars = it
                Picasso.get().load(it.img).into(binding.imageView3)
            }
        }

        binding.backBtnDetails.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_carsAboutFragment_to_SecondFragment)
        }

        val clickToChangePic = binding.imageSwitcher as ImageSwitcher
        clickToChangePic.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            clickToChangePic.showNext();
        }

        binding.bookBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_carsAboutFragment_to_fragmentFeedback)
        }
    }
}