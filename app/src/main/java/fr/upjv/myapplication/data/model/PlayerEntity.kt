package fr.upjv.myapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.upjv.myapplication.ui.model.ItemUi

@Entity(tableName = "PLAYER")
data class PlayerEntity(
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "position")
    val position: String,

    @ColumnInfo(name = "nationality") // Corrected spelling here
    val nationality: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

// Conversion functions
fun ItemUi.Item.toRoomObject(): PlayerEntity {
    return PlayerEntity(
        name = playerName,
        position = playerPosition,
        nationality = playerNationality  // Corrected spelling
    )
}

fun List<PlayerEntity>.toUi(): List<ItemUi.Item> {
    return map { eachItem ->
        ItemUi.Item(
            playerPosition = eachItem.position,
            playerName = eachItem.name,
            playerNationality = eachItem.nationality  // Corrected spelling
        )
    }
}
