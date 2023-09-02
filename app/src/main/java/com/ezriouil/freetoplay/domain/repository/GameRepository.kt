package com.ezriouil.freetoplay.domain.repository

import com.ezriouil.freetoplay.domain.model.Game
import com.ezriouil.freetoplay.domain.model.GameDetail
import com.ezriouil.freetoplay.utils.Resource

interface GameRepository {

    suspend fun getAllGames(): Resource<List<Game>?>?

    suspend fun getGame(id: Int): Resource<GameDetail>
}