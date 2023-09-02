package com.ezriouil.freetoplay.data.remote

import com.ezriouil.freetoplay.data.dto.GameDetailDto
import com.ezriouil.freetoplay.data.dto.GameDto
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("games")
    suspend fun getAllGames(): List<GameDto>

    @GET("game")
    suspend fun getGame(@Query("id") id: Int): GameDetailDto

}