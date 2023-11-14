package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.parchelo.databinding.FragmentInicioBinding
import datos.BaseDeDatos
import datos.Usuario.UsuarioDao
import kotlinx.coroutines.launch


class Inicio : Fragment() {

    private lateinit var binding: FragmentInicioBinding

    // Se crea una instacia de nuestra base de datos
    private val bd: BaseDeDatos by lazy {
        BaseDeDatos.getDatabase(requireActivity().baseContext)
    }

    private lateinit var UsuarioDao: UsuarioDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create the userDao from Database
        UsuarioDao = bd.UsuarioDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.BtnRegistrarse.setOnClickListener { findNavController().navigate(R.id.action_inicio_to_registro) }

        binding.BtnIniciar.setOnClickListener{
            lifecycleScope.launch {
                //Se obtiene tanto el email como la contraseña del usuario
                val usuario = UsuarioDao.obtenerUsuario(
                    binding.textInputLayoutEmail.editText?.text.toString(),
                    binding.textInputLayoutContraseA.editText?.text.toString()
                )
                //Se verifica que el usuario este dentro de la base de datos
                if(usuario != null){
                    findNavController().navigate(InicioDirections.actionInicioToPrincipal(Email = binding.textInputLayoutEmail.editText?.text.toString()))
                }else{
                    Toast.makeText(requireContext(), "Usuario y/o contraseña no existe.", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}


