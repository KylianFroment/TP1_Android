package fr.upjv.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.myapplication.data.repository.FootballPlayerRepository
import fr.upjv.myapplication.data.model.PlayerEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FootballPlayerViewModel(private val repository: FootballPlayerRepository) : ViewModel() {

    // Utilisez le bon Flow pour les joueurs de football
    val players: Flow<List<PlayerEntity>> = repository.selectAllPlayers()

    fun fetchRandomPlayer() {
        viewModelScope.launch {
            // Appeler la méthode correcte pour ajouter un joueur aléatoire
            val randomPlayer = PlayerEntity("Random Player", "Attaquant", "France")
            repository.insertPlayer(randomPlayer)
        }
    }

    fun deleteAllPlayers() {
        viewModelScope.launch {
            repository.deleteAllPlayers()
        }
    }
}
