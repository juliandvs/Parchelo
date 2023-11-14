package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.parchelo.databinding.FragmentPerfilBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Perfil : Fragment() {

    private lateinit var binding: FragmentPerfilBinding
    private lateinit var bar: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val root = binding.root

        bar = requireActivity().findViewById(R.id.bottomNavBar)
        bar.isGone = false


        bar.setOnItemSelectedListener {menuItem ->
            when (menuItem.itemId){
                R.id.home ->{
                    findNavController().navigate(R.id.action_perfil_to_principal)
                    true
                }
                R.id.guarda ->{
                    findNavController().navigate(R.id.action_perfil_to_guardados)
                    true
                }
                R.id.crea -> {
                    findNavController().navigate(R.id.action_perfil_to_guardados)
                    true
                }
                R.id.chatea -> {
                    findNavController().navigate(R.id.action_perfil_to_guardados)
                    true
                }
                R.id.perfil_usuario -> {
                    true
                }
                else -> false
            }
        }
        return root
    }
}