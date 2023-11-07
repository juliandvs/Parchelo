package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.parchelo.databinding.FragmentRegistroBinding

class Registro : Fragment() {

    private lateinit var binding: FragmentRegistroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentRegistroBinding.inflate(inflater, container, false)
        val root = binding.root

        val btn_registrarse = binding.BtnRegistrarUsuario
        btn_registrarse.setOnClickListener {
            findNavController().navigate(R.id.action_registro_to_menu)
        }

        return root
    }
}