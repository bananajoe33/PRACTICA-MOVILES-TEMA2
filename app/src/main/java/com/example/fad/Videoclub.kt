package com.example.fad

object Videoclub {
    val peliculas = mutableListOf(
        Pelicula(1, "In time", "Andrew Niccol", "Ciencia ficción", "Papel", true),
        Pelicula(2, "Guardianes de la galaxia", "James Gunn", "Acción", "Electrónico", true),
        Pelicula(3, "Como entrenar a tu dragón", "Dean DeBlois", "Fantasía", "Papel", false)
    )
    private var ultimoId = peliculas.size

    fun anadir(titulo: String, director, genero: String, valoracion: String, visto: Boolean) {
        ultimoId++
        peliculas.add(Pelicula(ultimoId, titulo, director, genero, valoracion, visto))
    }
    fun buscar(id: Int): Pelicula? = peliculas.find { it.id == id }
    fun borrar(id: Int) {
        peliculas.removeAll { it.id == id }
    }
    fun borrarTodos() {
        peliculas.clear()
    }
}