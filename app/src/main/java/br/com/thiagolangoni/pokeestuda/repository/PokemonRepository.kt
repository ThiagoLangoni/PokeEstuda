package br.com.thiagolangoni.pokeestuda.repository

import br.com.thiagolangoni.pokeestuda.model.Pokemon

interface PokemonRepository {
    fun checkHealth(
        onComplete:() -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun getPokemons(
        size: Int,
        sort: String,
        onComplete: (List<Pokemon>?) -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun updatePokemon(
        pokemon: Pokemon,
        onComplete:(Pokemon?) -> Unit,
        onError:(Throwable) -> Unit
    )
}