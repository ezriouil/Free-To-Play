package com.ezriouil.freetoplay.data.dto


import com.ezriouil.freetoplay.domain.model.MinimumSystemRequirements
import com.google.gson.annotations.SerializedName

data class MinimumSystemRequirementsDto(
    @SerializedName("graphics")
    val graphics: String? = null,
    @SerializedName("memory")
    val memory: String? = null,
    @SerializedName("os")
    val os: String? = null,
    @SerializedName("processor")
    val processor: String? = null,
    @SerializedName("storage")
    val storage: String? = null
) {
    fun toMinimumSystemRequirements(): MinimumSystemRequirements {
        return MinimumSystemRequirements(graphics, memory, os, processor, storage)
    }
}