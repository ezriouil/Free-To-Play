package com.ezriouil.freetoplay.data.dto

import com.ezriouil.freetoplay.domain.model.Game
import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("developer")
    val developer: String? = null,
    @SerializedName("freetogame_profile_url")
    val freeToGameProfileUrl: String? = null,
    @SerializedName("game_url")
    val gameUrl: String? = null,
    @SerializedName("genre")
    val genre: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("platform")
    val platform: String? = null,
    @SerializedName("publisher")
    val publisher: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("short_description")
    val shortDescription: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null,
    @SerializedName("title")
    val title: String? = null
) {
    fun toGame(): Game {
        return Game(
            developer,
            freeToGameProfileUrl,
            gameUrl,
            genre,
            id,
            platform,
            publisher,
            releaseDate,
            shortDescription,
            thumbnail,
            title
        )
    }
}