package fr.upjv.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.upjv.myapplication.data.model.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AndroidPlayerDao {

    @Query("SELECT * FROM PLAYER ORDER BY name ASC")
    fun selectAll(): Flow<List<PlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: PlayerEntity)

    @Query("DELETE FROM PLAYER")
    fun deleteAll()
}
