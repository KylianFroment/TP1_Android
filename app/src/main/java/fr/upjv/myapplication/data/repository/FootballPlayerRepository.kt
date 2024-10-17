package fr.upjv.myapplication.data.repository

import fr.upjv.myapplication.architecture.CustomApplication
import fr.upjv.myapplication.architecture.CustomRoomDatabase
import fr.upjv.myapplication.data.dao.AndroidPlayerDao
import fr.upjv.myapplication.data.model.PlayerEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FootballPlayerRepository {

    // Obtenez l'instance de DAO correcte
    private val androidPlayerDao: AndroidPlayerDao = CustomRoomDatabase
        .getDatabase(CustomApplication.instance.applicationContext)
        .androidPlayerDao()

    // Méthode pour sélectionner tous les joueurs
    fun selectAllPlayers(): Flow<List<PlayerEntity>> = androidPlayerDao.selectAll()

    // Méthode pour insérer un joueur
    suspend fun insertPlayer(player: PlayerEntity) {
        withContext(Dispatchers.IO) {
            androidPlayerDao.insert(player)
        }
    }

    // Méthode pour supprimer tous les joueurs
    suspend fun deleteAllPlayers() {
        withContext(Dispatchers.IO) {
            androidPlayerDao.deleteAll()
        }
    }
}
