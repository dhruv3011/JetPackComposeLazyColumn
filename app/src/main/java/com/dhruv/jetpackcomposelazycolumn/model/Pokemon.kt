package com.dhruv.jetpackcomposelazycolumn.model

data class PokemonList (val results: List<Pokemon>)

data class Pokemon(val name: String, val url: String) {
    val id: Int
        get() {
            val components = url.split("/")
            return components[components.size - 2].toIntOrNull() ?: 0
        }

    val imgUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}