package br.com.thiagolangoni.pokeestuda.view.form

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.thiagolangoni.pokeestuda.model.Pokemon
import br.com.thiagolangoni.pokeestuda.repository.PokemonRepository

class FormPokemonViewModel(val pokemonRepository: PokemonRepository) : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()

    val messageResponse = MutableLiveData<String>()

    fun updatePokemon(pokemon: Pokemon) {
        isLoading.value = true
        pokemonRepository.updatePokemon(
            pokemon = pokemon,
            onComplete = {
                isLoading.value = false
                messageResponse.value = "Dados atualizados com sucesso"
            },
            onError = {
                isLoading.value = false
                messageResponse.value = it.message
            }
        )
    }
}