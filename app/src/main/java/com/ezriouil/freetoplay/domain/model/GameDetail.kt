package com.ezriouil.freetoplay.domain.model


data class GameDetail(
    val description: String? = null,
    val developer: String? = null,
    val gameUrl: String? = null,
    val genre: String? = null,
    val minimumSystemRequirements: MinimumSystemRequirements? = null,
    val platform: String? = null,
    val publisher: String? = null,
    val releaseDate: String? = null,
    val screenshot: List<Screenshot?>? = null,
    val shortDescription: String? = null,
    val status: String? = null,
    val title: String? = null
)
