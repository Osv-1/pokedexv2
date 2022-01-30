package com.example.pokedexv2.repository

import com.example.pokedexv2.data.remote.PokeApi
import com.example.pokedexv2.data.remote.responses.Pokemon
import com.example.pokedexv2.data.remote.responses.PokemonList
import com.example.pokedexv2.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi


) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Um erro inesperado ocorreu.")
        }
        return Resource.Sucess(response)
    }

    suspend fun getPokemonInfo(pokemonName : String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("Um erro inesperado ocorreu.")
        }
        return Resource.Sucess(response)
    }
}


