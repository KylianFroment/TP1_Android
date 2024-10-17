package fr.upjv.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.myapplication.data.model.PlayerEntity
import fr.upjv.myapplication.data.repository.AndroidPlayerRepository
import fr.upjv.myapplication.ui.model.ItemUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random

class AndroidVersionViewModel : ViewModel() {

    // Instance du repository
    private val androidVersionRepository: AndroidPlayerRepository by lazy { AndroidPlayerRepository() }

    // Variable mutable en privée signifie que personne peut modifier le contenu à part le ViewModel lui-même.
    //private val _androidVersionList = MutableStateFlow<List<ItemUi>>(emptyList())


    private val _androidVersionList: Flow<List<ItemUi>>
        get() = androidVersionRepository.selectAllAndroidVersion().map { androidObjectEntities ->
            androidObjectEntities.groupBy { androidObjectEntity ->
                androidObjectEntity.playerPosition // Group by position (or other grouping criteria)
            }.flatMap { (position, players) ->
                buildList {
                    // Add Header for each group
                    add(ItemUi.Header(
                        title = position // Use the player's position as the header title
                    ))

                    // Add the player items for each position
                    addAll(players.map { playerEntity ->
                        ItemUi.Item(
                            playerName = playerEntity.playerName,
                            playerPosition = playerEntity.playerPosition,
                            playerNationality = playerEntity.playerNationality
                        )
                    })
                }
            }
        }


    // On rend accessible uniquement en lecture la valeur de la variable mutable afin de bloquer l'accès
    val androidVersionList : Flow<List<ItemUi>> get() = _androidVersionList

    /*
    init {
        viewModelScope.launch(Dispatchers.IO) {
            // On exécute dans un thread dédié à Input/Output le fait de générer la liste
            _androidVersionList.emit(populateMyList())
        }
    }
    */


    // Déplace la fonction ici pour qu'elle puisse accéder au repository
    private fun populateMyList(): List<ItemUi>      {
        val result = mutableListOf<ItemUi>()

        // Utilisation du repository pour récupérer la liste
        val players = androidVersionRepository.populateMyList()

        // Grouper les joueurs par position
        val groupedPlayers = players.groupBy { it.playerPosition }

        // Créer des headers et ajouter les joueurs sous chaque header
        groupedPlayers.forEach { (position, players) ->
            result.add(
                ItemUi.Header(
                    title = position // Utilisez la position comme titre du header
                )
            )
            result.addAll(players.map { player ->
                ItemUi.Item(
                    playerName = player.playerName,
                    playerPosition = player.playerPosition,
                    playerNationality = player.playerNationality
                )
            }) // Ajoutez tous les joueurs sous ce header
        }

        return result
    }

    fun insertPlayer() {
        viewModelScope.launch(Dispatchers.IO) {
            val random = Random.nextInt(0, 10)

            // Liste des positions possibles
            val positions = listOf("Gardien", "Défenseur", "Milieu", "Attaquant")

            // Sélection aléatoire d'une position
            val randomPosition = positions.random()

            // Insertion du joueur avec une position aléatoire
            androidVersionRepository.insertAndroidVersion(
                ItemUi.Item("Player $random", randomPosition, "Nationalité $random")
            )
        }
    }



    fun DeleteAllPlayer() {
        viewModelScope.launch(Dispatchers.IO) {
            androidVersionRepository.deleteAllAndroidVersion()
        }
    }
}

