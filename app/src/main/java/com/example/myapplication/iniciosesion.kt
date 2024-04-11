package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class iniciosesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_iniciosesion)

        var btnSiguiete = findViewById<Button>(R.id.btn_iniciar)
        var txtUsuario = findViewById<EditText>(R.id.txt_nombreUsuario)
        var txtPassword = findViewById<EditText>(R.id.txtPass_Contrasena)
        var txtApodo = findViewById<EditText>(R.id.textApodo)

        btnSiguiete.setOnClickListener{
            val usuario = txtUsuario.text.toString()
            val contra = txtPassword.text.toString()
            val apodo = txtApodo.text.toString()
            if(usuario == "Victor" && contra == "12345"){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("usuario", usuario)
                val sharedPref = this.getSharedPreferences("MiSharedPrefer", MODE_PRIVATE)
                with(sharedPref.edit()){
                    putString("apodo", apodo)
                    apply()
                }
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Contraseña incorrecta o usuario no existente", Toast.LENGTH_LONG).show()
            }
        }
    }
}