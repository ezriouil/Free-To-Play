package com.ezriouil.freetoplay.validation.state

data class ValidationResultState(
    val isValid: Boolean,
    val errorMsg: String = ""
)
