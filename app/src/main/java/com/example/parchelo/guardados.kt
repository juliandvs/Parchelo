package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.navigation.fragment.findNavController
import com.example.parchelo.databinding.FragmentGuardadosBinding
import com.example.parchelo.databinding.FragmentPrincipalBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
class guardados : Fragment() {

    private lateinit var binding: FragmentGuardadosBinding
    private lateinit var bar: BottomNavigationView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGuardadosBinding.inflate(inflater, container, false)
        val root = binding.root

        bar = requireActivity().findViewById(R.id.bottomNavBar)
        bar.isGone = false

        bar.setOnItemSelectedListener {menuItem ->
            when (menuItem.itemId){
                R.id.home ->{
                    findNavController().navigate(R.id.action_guardados_to_principal)
                    true
                }
                R.id.guarda ->{
                    true
                }
                R.id.crea -> {
                    findNavController().navigate(R.id.action_guardados_to_crear)
                    true
                }
                R.id.chatea -> {
                    findNavController().navigate(R.id.action_guardados_to_chat)
                    true
                }
                R.id.perfil_usuario -> {
                    findNavController().navigate(R.id.action_guardados_to_perfil)
                    true
                }
                else -> false
            }
        }

        return root
    }

}