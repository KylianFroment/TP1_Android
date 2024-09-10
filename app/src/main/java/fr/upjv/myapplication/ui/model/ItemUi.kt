package fr.upjv.myapplication.ui.model

sealed interface ItemUi {

    data class MyAndroidObject(
        val playerName: String, // Nom du joueur
        val playerPosition: String, // Position du joueur
        val nationality: String // Nationalité du joueur
    ) : ItemUi


    data class Header(
        val title: String,
    ) : ItemUi

    data class PlayerGroup(
        val position: String,       // Position du joueur (Gardien, Défenseur, Milieu, Attaquant)
        val players: List<ItemUi.MyAndroidObject> // Liste de joueurs pour chaque position
    )



}