package com.example.tabla_periodica

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Imagen_periodica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen_periodica)
        enableEdgeToEdge()
        // accedemos a la imagen de la tabla periodica
        val tablaPeriodica = findViewById<AppCompatImageView>(R.id.imageView3)
        // Cambia la imagen en tiempo de ejecución
        tablaPeriodica.setImageResource(R.drawable.imagen)
        tablaPeriodica.setOnClickListener {
            tablaPeriodica.setImageResource(R.drawable.beta1)
        }
    }

}
