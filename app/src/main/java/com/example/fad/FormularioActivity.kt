package com.example.fad

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fad.databinding.ActivityFormularioBinding


class FormularioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.botonGuardar.setOnClickListener { guardar() }
        binding.botonCancelar.setOnClickListener { finish() }

    }

    private fun guardar() {
        val titulo = binding.editTitulo.text.toString().trim()
        val director = binding.editDirector.text.toString().trim()

        if (titulo.isEmpty()){
            binding.editTitulo.error = getString(R.string.error_obligatorio)
            binding.editTitulo.requestFocus()
            return
        }

        if (director.isEmpty()){
            binding.editDirector.error = getString(R.string.error_obligatorio)
            binding.editDirector.requestFocus()
            return
        }

        val genero = binding.spinnerGenero.selectedItem.toString()

        val valoracion = when (binding.grupoValoracion.checkedRadioButtonId){
            R.id.radio_malo -> getString(R.string.malo)
            R.id.radio_excelente -> getString(R.string.excelente)
            else -> getString(R.string.bueno)
        }

        val visto = binding.checkVisto.isChecked

        Videoclub.anadir(titulo, director, genero, valoracion, visto)
        Toast.makeText(this, R.string.pelicula_guardada, Toast.LENGTH_SHORT).show()
        finish()
    }
}