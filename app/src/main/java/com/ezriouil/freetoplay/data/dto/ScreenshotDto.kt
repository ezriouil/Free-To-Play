package com.ezriouil.freetoplay.data.dto

import com.ezriouil.freetoplay.domain.model.Screenshot
import com.google.gson.annotations.SerializedName

data class ScreenshotDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null
) {
    fun toScreenshot(): Screenshot {
        return Screenshot(id, image)
    }
}