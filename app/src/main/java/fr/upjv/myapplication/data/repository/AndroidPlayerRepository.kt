package fr.upjv.myapplication.data.repository

import fr.upjv.myapplication.architecture.CustomApplication
import fr.upjv.myapplication.architecture.CustomRoomDatabase
import fr.upjv.myapplication.data.dao.AndroidPlayerDao
import fr.upjv.myapplication.data.model.AndroidObject
import fr.upjv.myapplication.data.model.toRoomObject
import fr.upjv.myapplication.data.model.toUi
import fr.upjv.myapplication.ui.model.toUi
import fr.upjv.myapplication.ui.model.ItemUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AndroidPlayerRepository {

    fun populateMyList(): List<AndroidObject> {
        return listOf(
            AndroidObject(
                playerName = "Gianluigi Donnarumma",
                playerPosition = "Gardien",
                playerNationality = "Italie"
            ),
            AndroidObject(
                playerName = "Keylor Navas",
                playerPosition = "Gardien",
                playerNationality = "Costa Rica"
            ),
            AndroidObject(
                playerName = "Arnau Tenas",
                playerPosition = "Gardien",
                playerNationality = "Espagne"
            ),
            AndroidObject(
                playerName = "Alexandre Letellier",
                playerPosition = "Gardien",
                playerNationality = "France"
            ),

            AndroidObject(
                playerName = "Achraf Hakimi",
                playerPosition = "Défenseur",
                playerNationality = "Maroc"
            ),
            AndroidObject(
                playerName = "Milan Škriniar",
                playerPosition = "Défenseur",
                playerNationality = "Slovaquie"
            ),
            AndroidObject(
                playerName = "Marquinhos",
                playerPosition = "Défenseur",
                playerNationality = "Brésil"
            ),
            AndroidObject(
                playerName = "Lucas Hernandez",
                playerPosition = "Défenseur",
                playerNationality = "France"
            ),
            AndroidObject(
                playerName = "Presnel Kimpembe",
                playerPosition = "Défenseur",
                playerNationality = "France"
            ),
            AndroidObject(
                playerName = "Danilo Pereira",
                playerPosition = "Défenseur",
                playerNationality = "Portugal"
            ),
            AndroidObject(
                playerName = "Nordi Mukiele",
                playerPosition = "Défenseur",
                playerNationality = "France"
            ),
            AndroidObject(
                playerName = "Layvin Kurzawa",
                playerPosition = "Défenseur",
                playerNationality = "France"
            ),
            AndroidObject(
                playerName = "Juan Bernat",
                playerPosition = "Défenseur",
                playerNationality = "Espagne"
            ),

            AndroidObject(
                playerName = "Manuel Ugarte",
                playerPosition = "Milieu",
                playerNationality = "Uruguay"
            ),
            AndroidObject(
                playerName = "Vitinha",
                playerPosition = "Milieu",
                playerNationality = "Portugal"
            ),
            AndroidObject(
                playerName = "Warren Zaïre-Emery",
                playerPosition = "Milieu",
                playerNationality = "France"
            ),
            AndroidObject(
                playerName = "Carlos Soler",
                playerPosition = "Milieu",
                playerNationality = "Espagne"
            ),
            AndroidObject(
                playerName = "Fabián Ruiz",
                playerPosition = "Milieu",
                playerNationality = "Espagne"
            ),
            AndroidObject(
                playerName = "Cher Ndour",
                playerPosition = "Milieu",
                playerNationality = "Italie"
            ),
            AndroidObject(
                playerName = "Kang-In Lee",
                playerPosition = "Milieu",
                playerNationality = "Corée du Sud"
            ),

            AndroidObject(
                playerName = "Kylian Mbappé",
                playerPosition = "Attaquant",
                playerNationality = "France"
            ),
            AndroidObject(
                playerName = "Ousmane Dembélé",
                playerPosition = "Attaquant",
                playerNationality = "France"
            ),
            AndroidObject(
                playerName = "Gonçalo Ramos",
                playerPosition = "Attaquant",
                playerNationality = "Portugal"
            ),
            AndroidObject(
                playerName = "Marco Asensio",
                playerPosition = "Attaquant",
                playerNationality = "Espagne"
            ),
            AndroidObject(
                playerName = "Randal Kolo Muani",
                playerPosition = "Attaquant",
                playerNationality = "France"
            ),
            AndroidObject(
                playerName = "Bradley Barcola",
                playerPosition = "Attaquant",
                playerNationality = "France"
            )
        )
    }

    // Get the database instance and DAO
    private val androidPlayerDao: AndroidPlayerDao = CustomRoomDatabase
        .getDatabase(CustomApplication.instance.applicationContext)
        .androidPlayerDao()

    // Fetch all Android versions (players) from the local database
    fun selectAllAndroidVersion(): Flow<List<ItemUi.Item>> {
        return androidPlayerDao.selectAll().map { it.toUi() }
    }

    // Insert a new Android version (player) into the local database
    fun insertAndroidVersion(androidObject: ItemUi.Item) {
        androidPlayerDao.insert(androidObject.toRoomObject())
    }

    // Delete all Android versions (players) from the local database
    fun deleteAllAndroidVersion() {
        androidPlayerDao.deleteAll()
    }

}
