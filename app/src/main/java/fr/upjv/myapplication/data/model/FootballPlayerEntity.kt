package fr.upjv.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "football_player_table")
data class FootballPlayerEntity(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("position") val position: String,
    @SerializedName("nationality") val nationality: String
)
