package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val bienvenida = findViewById<TextView>(R.id.txt_Bienvenida)
        val usuario = intent.getStringExtra("usuario")
        val sharedPref = this.getSharedPreferences("MiSharedPrefer", MODE_PRIVATE)
        val apodo = sharedPref.getString("apodo", "")
        bienvenida.append(" " + apodo)
    }
}