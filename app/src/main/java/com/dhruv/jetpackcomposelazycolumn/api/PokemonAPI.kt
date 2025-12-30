package com.dhruv.jetpackcomposelazycolumn.api

import com.dhruv.jetpackcomposelazycolumn.model.Pokemon
import com.dhruv.jetpackcomposelazycolumn.model.PokemonList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object PokemonAPI {

    interface PokemonAPI {
        @GET("pokemon?limit=151")
        fun getPokemon(): Call<PokemonList>
    }

    fun loadPokemon(success: (pokemonList: List<Pokemon>) -> Unit, failure: () -> Unit) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PokemonAPI::class.java)

        service.getPokemon().enqueue(object : Callback<PokemonList> {
            override fun onResponse(
                call: Call<PokemonList?>,
                response: Response<PokemonList?>
            ) {
                success(response.body()?.results ?: listOf())
            }

            override fun onFailure(
                call: Call<PokemonList?>,
                t: Throwable
            ) {
                failure()
            }

        })
    }
}