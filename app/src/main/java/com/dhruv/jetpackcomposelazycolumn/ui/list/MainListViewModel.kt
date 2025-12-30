package com.dhruv.jetpackcomposelazycolumn.ui.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dhruv.jetpackcomposelazycolumn.api.PokemonAPI
import com.dhruv.jetpackcomposelazycolumn.model.Pokemon

class MainListViewModel : ViewModel() {

    var pokemonList: List<Pokemon> by mutableStateOf(listOf())

    init {
        loadData()
    }

    private fun loadData() {
        PokemonAPI.loadPokemon({ it ->
            pokemonList = it
        }, {

        })
    }
}