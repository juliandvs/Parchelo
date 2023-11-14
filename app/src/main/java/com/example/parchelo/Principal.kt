package com.example.parchelo

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parchelo.databinding.FragmentPrincipalBinding
import com.example.parchelo.recycler.Evento
import com.example.parchelo.recycler.Provedor
import com.example.parchelo.recycler.eventoAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView


class Principal : Fragment() {


    private lateinit var binding: FragmentPrincipalBinding
    private lateinit var bar: BottomNavigationView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBackPressListener()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrincipalBinding.inflate(inflater, container, false)
        val root =binding.root
        initRecyclerView()

        bar = requireActivity().findViewById(R.id.bottomNavBar)
        bar.isGone = false

        bar.setOnItemSelectedListener {menuItem ->
            when (menuItem.itemId){
                R.id.home ->{
                    true
                }
                R.id.guarda ->{
                    findNavController().navigate(R.id.action_principal_to_guardados)
                    true
                }
                R.id.crea -> {
                    findNavController().navigate(R.id.action_principal_to_crear)
                    true
                }
                R.id.chatea -> {
                    findNavController().navigate(R.id.action_principal_to_chat)
                    true
                }
                R.id.perfil_usuario -> {
                    findNavController().navigate(R.id.action_principal_to_perfil)
                    true
                }
                else -> false
            }
        }
        return root
    }


    private fun initRecyclerView(){
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = eventoAdapter(Provedor.eventos,{onItemselected(it)})
    }

    fun onItemselected(evento: Evento){
        findNavController().navigate(PrincipalDirections.actionPrincipalToEvento(Titulo = evento.titulo, Fecha = evento.fecha, Lugar = evento.lugar))
    }

    private fun setupBackPressListener() {
        this.view?.isFocusableInTouchMode = true
        this.view?.requestFocus()
        this.view?.setOnKeyListener { _, keyCode, _ ->
            keyCode == KeyEvent.KEYCODE_BACK
        }
    }


}