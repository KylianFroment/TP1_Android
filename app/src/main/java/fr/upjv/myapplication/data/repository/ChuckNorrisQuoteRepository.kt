package fr.upjv.myapplication.data.repository

import fr.upjv.myapplication.architecture.CustomApplication
import fr.upjv.myapplication.architecture.RetrofitBuilder
import fr.upjv.myapplication.ui.model.ChuckNorrisObject

import fr.upjv.myapplication.data.model.toRoom

import fr.upjv.myapplication.ui.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChuckNorrisQuoteRepository {
    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.chuckNorrisDao()

    suspend fun fetchData() {
        chuckNorrisDao.insert(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }

    fun deleteAll() {
        chuckNorrisDao.deleteAll()
    }

    fun selectAll(): Flow<List<ChuckNorrisObject>> {
        return chuckNorrisDao.selectAll().map { list ->
            list.toUi()
        }
    }
}
