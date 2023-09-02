package com.ezriouil.freetoplay.validation.event

sealed class ValidationResultEvent {
    object Success : ValidationResultEvent()
}
