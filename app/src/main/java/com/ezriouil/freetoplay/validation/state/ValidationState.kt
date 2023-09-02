package com.ezriouil.freetoplay.validation.state

import com.ezriouil.freetoplay.utils.TextFieldType

data class ValidationState(
    val text: String = "",
    val textFieldType: TextFieldType = TextFieldType.TEXT,
    val isRequired: Boolean = true,
    val hasError: Boolean = true,
    val errorMsg: String? = null
)
