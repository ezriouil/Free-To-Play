package com.ezriouil.freetoplay.validation.event

import com.ezriouil.freetoplay.validation.state.ValidationState

sealed class ValidationEvent {
    object Submit : ValidationEvent()
    data class TextFieldValueChange(val validationState: ValidationState) : ValidationEvent()
}
