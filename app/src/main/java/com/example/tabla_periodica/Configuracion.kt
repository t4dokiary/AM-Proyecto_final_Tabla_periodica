package com.example.tabla_periodica

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class Configuracion : AppCompatActivity() {
    private lateinit var switchDarkMode: Switch
    private lateinit var seekBar: SeekBar
    private lateinit var textView: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        // Inicializar vistas
        switchDarkMode = findViewById(R.id.switch_modo)
        seekBar = findViewById(R.id.seekBar)
        textView = findViewById(R.id.textView_modo_oscuro) // Cambia esto si necesitas un TextView específico para mostrar el texto

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE)

        // Cargar configuraciones
        loadSettings()

        // Configurar listener para el Switch
        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            AppCompatDelegate.setDefaultNightMode(if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
            saveSettings()
        }

        // Configurar listener para el SeekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                textView.textSize = progress.toFloat() // Cambia el tamaño del texto
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                saveSettings() // Guarda el tamaño del texto cuando el usuario deja de interactuar con el SeekBar
            }
        })
    }

    private fun loadSettings() {
        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)
        val textSize = sharedPreferences.getInt("text_size", 14) // Carga el tamaño del texto

        switchDarkMode.isChecked = isDarkMode
        seekBar.progress = textSize
        textView.textSize = textSize.toFloat()

        AppCompatDelegate.setDefaultNightMode(if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun saveSettings() {
        with(sharedPreferences.edit()) {
            putBoolean("dark_mode", switchDarkMode.isChecked)
            putInt("text_size", seekBar.progress) // Guarda el tamaño del texto
            apply()
        }
    }
}





/*package com.example.tabla_periodica

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Configuracion : AppCompatActivity() {
    private lateinit var switchDarkMode: Switch
    private lateinit var seekBar: SeekBar
    private lateinit var textView: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        // Inicializar vistas
        switchDarkMode = findViewById(R.id.switch_modo)
        seekBar = findViewById(R.id.seekBar)
        textView = findViewById(R.id.textView_modo_oscuro) // Cambia esto si necesitas un TextView específico para mostrar el texto

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE)

        // Cargar configuraciones
        loadSettings()

        // Configurar listener para el Switch
        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            AppCompatDelegate.setDefaultNightMode(if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
            saveSettings()
        }

        // Configurar listener para el SeekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                textView.textSize = progress.toFloat() // Cambia el tamaño del texto
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }

    private fun loadSettings() {
        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)
        val textSize = sharedPreferences.getInt("text_size", 14) // Carga el tamaño del texto

        switchDarkMode.isChecked = isDarkMode
        seekBar.progress = textSize
        textView.textSize = textSize.toFloat()

        AppCompatDelegate.setDefaultNightMode(if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun saveSettings() {
        with(sharedPreferences.edit()) {
            putBoolean("dark_mode", switchDarkMode.isChecked)
            putInt("text_size", seekBar.progress) // Guarda el tamaño del texto
            apply()
        }
    }
}*/