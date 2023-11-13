package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parchelo.databinding.FragmentEventoBinding



class Evento : Fragment() {

    private lateinit var binding : FragmentEventoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventoBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

}