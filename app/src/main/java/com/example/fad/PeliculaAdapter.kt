package com.example.fad

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fad.databinding.ItemPeliculaBinding

class PeliculaAdapter(
    private val peliculas: List<Pelicula>,
    private val onPeliculaClick: (Pelicula) -> Unit
) : RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder>() {

    inner class PeliculaViewHolder(private val binding: ItemPeliculaBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pelicula: Pelicula) {
            binding.tituloPelicula.text = pelicula.titulo
            binding.directorPelicula.text = pelicula.director

            binding.root.setOnClickListener {
                onPeliculaClick(pelicula)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val binding = ItemPeliculaBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PeliculaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        holder.bind(peliculas[position])
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }
}
