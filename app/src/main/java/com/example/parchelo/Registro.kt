package com.example.parchelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.parchelo.databinding.FragmentRegistroBinding
import datos.BaseDeDatos
import datos.Usuario.Usuario
import datos.Usuario.UsuarioDao
import kotlinx.coroutines.launch

class Registro : Fragment() {

    private lateinit var binding: FragmentRegistroBinding

    // Se crea una instacia de nuestra base de datos
    private val bd: BaseDeDatos by lazy {
        BaseDeDatos.getDatabase(requireActivity().baseContext)
    }

    private lateinit var UsuarioDao: UsuarioDao

    /**
     * OnCreate : se hace el llamado a esta función cuando la actividad/Fragment
     * esta siendo creada por primera vez o cuando esta siendo recreada
     * después de haber sido destruida.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create the userDao from Database
        UsuarioDao = bd.UsuarioDao()
    }

    /**
     * OnCreateView: Se utiliza para inflar y configurar la vista del fragment.
     * Este metodo se llama cuando el fragmento está siendo creado y necesita proporcionar
     * su interfaz de usuario.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentRegistroBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    /**
     * OnViewCreated : Se llama despues de llamar al metodo OnCreateView, en este punto,
     * la vista ya ha sido creada, y se puede realizar operaciones adicionales en la vista (Componentes de Interfaz, Adaptadore, etc)
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.BtnRegistrarUsuario.setOnClickListener {
            lifecycleScope.launch {
                val nombre = binding.textInputLayout.editText?.text.toString().trim()
                val apellido = binding.textInputLayout3.editText?.text.toString().trim()
                val edad = binding.txtEdad.editText?.text.toString().trim()
                val nombreUsuario = binding.textInputLayout4.editText?.text.toString().trim()
                val email = binding.textInputLayout5.editText?.text.toString().trim()
                val contrasena = binding.textInputLayout6.editText?.text.toString().trim()
                val contrasenaValidacion = binding.textInputLayout7.editText?.text.toString().trim()

                if(nombre.isEmpty() || apellido.isEmpty() || nombreUsuario.isEmpty() ||
                    email.isEmpty() || contrasena.isEmpty() || contrasenaValidacion.isEmpty()){ //Se verifica que todos los campos esten completos
                    //TODO poner asteriscos a todos los campos o los que sean obligatorios
                    Toast.makeText(requireContext(), "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }else if(UsuarioDao.verificarUsuario(nombreUsuario)) { //Se verifica que el usuario no exista en la base de datos
                    Toast.makeText(requireContext(), "El nombre de usuario ya esta en uso", Toast.LENGTH_SHORT).show()
                }else if(contrasena != contrasenaValidacion) { //Se verifica que la contraseña y la contraseña de validacion sean la misma
                    Toast.makeText(requireContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }else if(UsuarioDao.verificarEmail(email)) { //Se verifica que el email no este en uso
                    Toast.makeText(requireContext(), "El email ya esta en uso", Toast.LENGTH_SHORT).show()
                }else if(edad.isEmpty() || edad.toInt() < 18){//Se verifica que el usuario sea mayor de edad
                    Toast.makeText(requireContext(), "Debes ser mayor de edad", Toast.LENGTH_SHORT).show()
                }else{
                    //Se agrega el usuario a la base de datos :)
                    val usuarioNuevo = Usuario(0, nombre, apellido,edad, nombreUsuario, email, contrasena)
                    UsuarioDao.insertarUsuario(usuarioNuevo)
                    Toast.makeText(requireContext(), "Usuario Registrado", Toast.LENGTH_SHORT).show()
                    limpiarCampos()
                }

            }
        }
    }

    /**
     * Limpia los campos del registro
     */
    private fun limpiarCampos() {
        binding.textInputLayout.editText?.text?.clear()
        binding.textInputLayout3.editText?.text?.clear()
        binding.textInputLayout4.editText?.text?.clear()
        binding.textInputLayout5.editText?.text?.clear()
        binding.textInputLayout6.editText?.text?.clear()
        binding.textInputLayout7.editText?.text?.clear()
        binding.txtEdad.editText?.text?.clear()
    }
}