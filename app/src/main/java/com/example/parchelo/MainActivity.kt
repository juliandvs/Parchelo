package com.example.parchelo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import androidx.navigation.ui.AppBarConfiguration
import com.example.parchelo.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var appBarConfiguration: AppBarConfiguration

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavBar.isGone = true

        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.principal, R.id.guardados, R.id.crear,
            R.id.chat,R.id.perfil))
    }
}