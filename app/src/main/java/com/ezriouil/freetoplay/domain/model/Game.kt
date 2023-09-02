package com.ezriouil.freetoplay.domain.model

data class Game(
    val developer: String? = null,
    val freeToGameProfileUrl: String? = null,
    val gameUrl: String? = null,
    val genre: String? = null,
    val id: Int? = null,
    val platform: String? = null,
    val publisher: String? = null,
    val releaseDate: String? = null,
    val shortDescription: String? = null,
    val thumbnail: String? = null,
    val title: String? = null
)