package com.example.parchelo

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController
import com.example.parchelo.databinding.FragmentMenuBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class menu : Fragment() {

    private lateinit var binding : FragmentMenuBinding

    lateinit var navegacion : BottomNavigationView

    private val OnNavMenu = BottomNavigationView.OnNavigationItemSelectedListener {
        item ->
        when(item.itemId){
            R.id.home ->{
                childFragmentManager.commit{
                    replace<Principal>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.guarda ->{
                childFragmentManager.commit{
                    replace<guardados>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.crea ->{
                childFragmentManager.commit{
                    replace<Crear>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.chatea ->{
                childFragmentManager.commit{
                    replace<chat>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.perfil_usuario->{
                childFragmentManager.commit{
                    replace<Perfil>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater,container,false)
        val root = binding.root
        childFragmentManager.commit{
            replace<Principal>(R.id.frameContainer)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }
        navegacion = binding.bottomNavigationView
        navegacion.setOnNavigationItemSelectedListener(OnNavMenu)

        return root
    }




}