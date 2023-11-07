package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.parchelo.databinding.FragmentInicioBinding


class Inicio : Fragment() {

    private lateinit var binding: FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        val root = binding.root

        val btn_registrarse = binding.BtnRegistrarse
        btn_registrarse.setOnClickListener {
            findNavController().navigate(R.id.action_inicio_to_registro) }

        val btn_iniciarsesion  = binding.BtnIniciar
        btn_iniciarsesion.setOnClickListener{
            findNavController().navigate(R.id.action_inicio_to_menu)
        }

        return root
    }
}