package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.navigation.fragment.findNavController
import com.example.parchelo.databinding.FragmentChatBinding
import com.example.parchelo.databinding.FragmentCrearBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class chat : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private lateinit var bar: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        val root = binding.root

        bar = requireActivity().findViewById(R.id.bottomNavBar)
        bar.isGone = false

        bar.setOnItemSelectedListener {menuItem ->
            when (menuItem.itemId){
                R.id.home ->{
                    findNavController().navigate(R.id.action_chat_to_principal)
                    true
                }
                R.id.guarda ->{
                    findNavController().navigate(R.id.action_chat_to_guardados)
                    true
                }
                R.id.crea -> {
                    findNavController().navigate(R.id.action_chat_to_guardados)
                    true
                }
                R.id.chatea -> {
                    true
                }
                R.id.perfil_usuario -> {
                    findNavController().navigate(R.id.action_chat_to_perfil)
                    true
                }
                else -> false
            }
        }

        return root
    }
}