package com.ezriouil.freetoplay.data.dto


import com.ezriouil.freetoplay.domain.model.GameDetail
import com.google.gson.annotations.SerializedName

data class GameDetailDto(
    @SerializedName("description")
    val description: String? = null,
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
    @SerializedName("minimum_system_requirements")
    val minimumSystemRequirementsDto: MinimumSystemRequirementsDto? = null,
    @SerializedName("platform")
    val platform: String? = null,
    @SerializedName("publisher")
    val publisher: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("screenshots")
    val screenshotDto: List<ScreenshotDto?>? = null,
    @SerializedName("short_description")
    val shortDescription: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null,
    @SerializedName("title")
    val title: String? = null
) {
    fun toGameDetail(): GameDetail {
        return GameDetail(
            developer = developer,
            gameUrl = gameUrl,
            genre = genre,
            minimumSystemRequirements = minimumSystemRequirementsDto?.toMinimumSystemRequirements(),
            platform = platform,
            publisher = publisher,
            releaseDate = releaseDate,
            screenshot = screenshotDto?.map { it?.toScreenshot() },
            shortDescription = shortDescription,
            status = status,
            title = title
        )
    }
}