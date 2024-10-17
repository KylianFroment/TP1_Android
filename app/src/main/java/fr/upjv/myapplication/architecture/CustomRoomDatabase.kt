package fr.upjv.myapplication.architecture

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.upjv.myapplication.data.dao.AndroidPlayerDao
import fr.upjv.myapplication.data.model.PlayerEntity
import fr.upjv.myapplication.data.dao.ChuckNorrisDao
import fr.upjv.myapplication.data.model.ChuckNorrisEntity

@Database(
    entities = [ChuckNorrisEntity::class, PlayerEntity::class],  // Include PlayerEntity
    version = 3,  // Increment version number
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun chuckNorrisDao(): ChuckNorrisDao
    abstract fun androidPlayerDao(): AndroidPlayerDao

    companion object {
        @Volatile
        private var INSTANCE: CustomRoomDatabase? = null

        fun getDatabase(context: Context): CustomRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CustomRoomDatabase::class.java,
                    "custom_database"
                )
                    .fallbackToDestructiveMigration()  // Optional: resets the database on version change
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
