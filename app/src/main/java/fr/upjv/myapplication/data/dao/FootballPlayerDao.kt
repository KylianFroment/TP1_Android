package fr.upjv.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.upjv.myapplication.data.model.FootballPlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FootballPlayerDao {

    @Query("SELECT * FROM football_player_table ORDER BY name ASC")
    fun selectAll(): Flow<List<FootballPlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(footballPlayerEntity: FootballPlayerEntity)

    @Query("DELETE FROM football_player_table")
    fun deleteAll()
}
