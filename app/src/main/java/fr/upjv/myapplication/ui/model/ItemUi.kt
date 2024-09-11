package fr.upjv.myapplication.ui.model

import fr.upjv.myapplication.data.model.AndroidObject

sealed interface ItemUi {

    data class Item(
        val playerName: String, // Nom du joueur
        val playerPosition: String, // Position du joueur
        val playerNationality: String // Nationalité du joueur
    ) : ItemUi


    data class Header(
        val title: String,
    ) : ItemUi

    data class PlayerGroup(
        val position: String,       // Position du joueur (Gardien, Défenseur, Milieu, Attaquant)
        val players: List<ItemUi.Item> // Liste de joueurs pour chaque position
    ) : ItemUi

}

fun List<AndroidObject>.toUi(): List<ItemUi.Item> {
    return map { currentAndroidObject ->
        ItemUi.Item(
            playerName = currentAndroidObject.playerName, // Nom du joueur
            playerPosition = currentAndroidObject.playerPosition, // Position du joueur
            playerNationality = currentAndroidObject.playerNationality // Nationalité du joueur
        )
    }
}
