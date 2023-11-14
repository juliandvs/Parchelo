package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.navigation.fragment.navArgs
import com.example.parchelo.databinding.FragmentEventoBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Evento : Fragment() {


    private val args: EventoArgs by navArgs()
    private lateinit var binding : FragmentEventoBinding
    private lateinit var bar: BottomNavigationView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventoBinding.inflate(inflater, container, false)
        val root = binding.root
        bar = requireActivity().findViewById(R.id.bottomNavBar)
        bar.isGone = true
        binding.tituloEventoDetalles.setText(args.Titulo)
        binding.fechaEventoDetalles.setText(args.Fecha)
        binding.lugarEventoDetalles.setText(args.Lugar)
        return root
    }

}