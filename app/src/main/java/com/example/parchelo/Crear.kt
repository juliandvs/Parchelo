package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.navigation.fragment.findNavController
import com.example.parchelo.databinding.FragmentCrearBinding
import com.example.parchelo.databinding.FragmentGuardadosBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

private lateinit var binding: FragmentCrearBinding
private lateinit var bar: BottomNavigationView
class Crear : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrearBinding.inflate(inflater, container, false)
        val root = binding.root

        bar = requireActivity().findViewById(R.id.bottomNavBar)
        bar.isGone = false

        bar.setOnItemSelectedListener {menuItem ->
            when (menuItem.itemId){
                R.id.home ->{
                    findNavController().navigate(R.id.action_crear_to_principal)
                    true
                }
                R.id.guarda ->{
                    findNavController().navigate(R.id.action_crear_to_guardados)
                    true
                }
                R.id.crea -> {
                    true
                }
                R.id.chatea -> {
                    findNavController().navigate(R.id.action_crear_to_chat)
                    true
                }
                R.id.perfil_usuario -> {
                    findNavController().navigate(R.id.action_crear_to_perfil)
                    true
                }
                else -> false
            }
        }

        return root
    }
}