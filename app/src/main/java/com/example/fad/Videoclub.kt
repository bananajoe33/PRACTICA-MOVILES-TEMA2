package com.example.fad

object Videoclub {
    val peliculas = mutableListOf(
        Pelicula(1, "In time", "Gabriel García Márquez", "Novela", "Papel"),
        Pelicula(2, "Guardianes de la galaxia", "Yuval Noah Harari", "Ensayo", "Electrónico"),
        Pelicula(3, "Como entrenar a tu dragón", "Pablo Neruda", "Poesía", "Papel")
    )
    private var ultimoId = peliculas.size

    fun anadir(titulo: String, autor: String, genero: String, formato: String, leido: Boolean) {
        ultimoId++
        peliculas.add(Pelicula(ultimoId, titulo, autor, genero, formato))
    }
    fun buscar(id: Int): Pelicula? = peliculas.find { it.id == id }
    fun borrar(id: Int) {
        peliculas.removeAll { it.id == id }
    }
    fun borrarTodos() {
        peliculas.clear()
    }
}