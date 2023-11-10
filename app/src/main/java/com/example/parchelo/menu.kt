package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.parchelo.databinding.FragmentMenuBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class menu : Fragment() {

    private lateinit var binding : FragmentMenuBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater,container,false)


        val root = binding.root
        val btn_nav = binding.bottomNavigationView

        return root
    }

}