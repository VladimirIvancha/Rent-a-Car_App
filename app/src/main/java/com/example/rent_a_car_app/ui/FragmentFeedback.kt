package com.example.rent_a_car_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.rent_a_car_app.R
import com.example.rent_a_car_app.databinding.FragmentFeedbackBinding

class FragmentFeedback : Fragment() {

    lateinit var binding: FragmentFeedbackBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedbackBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtnFeedback.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_fragmentFeedback_to_SecondFragment)
        }
    }
}