package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parchelo.databinding.FragmentInicioBinding
import com.example.parchelo.databinding.FragmentPrincipalBinding
import com.example.parchelo.recycler.Provedor
import com.example.parchelo.recycler.eventoAdapter


class Principal : Fragment() {

    private lateinit var binding: FragmentPrincipalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrincipalBinding.inflate(inflater, container, false)
        val root =binding.root
        initRecyclerView()
        return root
    }


    private fun initRecyclerView(){
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = eventoAdapter(Provedor.eventos)
    }


}