package com.ezriouil.freetoplay.data.repository

import com.ezriouil.freetoplay.data.remote.Api
import com.ezriouil.freetoplay.domain.model.Game
import com.ezriouil.freetoplay.domain.model.GameDetail
import com.ezriouil.freetoplay.domain.repository.GameRepository
import com.ezriouil.freetoplay.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(private val api: Api) : GameRepository {

    override suspend fun getAllGames(): Resource<List<Game>> {
        val response = api.getAllGames()
        return withContext(Dispatchers.IO) {
            Resource.Loading
            try {
                Resource.Success(data = response.map { it.toGame() })
            } catch (e: Exception) {
                Resource.Error(msg = e.message.toString())
            }
        }
    }

    override suspend fun getGame(id: Int): Resource<GameDetail> {
        val response = api.getGame(id)
        return withContext(Dispatchers.IO) {
            Resource.Loading
            try {
                Resource.Success(data = response.toGameDetail())
            } catch (e: Exception) {
                Resource.Error(msg = e.message.toString())
            }
        }
    }
}
