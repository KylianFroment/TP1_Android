package fr.upjv.myapplication.ui.model

import fr.upjv.myapplication.data.model.FootballPlayerEntity

data class FootballPlayerItemUi(
    val id: Int,
    val name: String,
    val position: String,
    val nationality: String
)

fun List<FootballPlayerEntity>.toUi(): List<FootballPlayerItemUi> {
    return map { player ->
        FootballPlayerItemUi(
            id = player.id,
            name = player.name,
            position = player.position,
            nationality = player.nationality
        )
    }
}
