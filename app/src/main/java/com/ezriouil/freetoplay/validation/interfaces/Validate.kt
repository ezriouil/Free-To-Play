package com.ezriouil.freetoplay.validation.interfaces

import com.ezriouil.freetoplay.validation.state.ValidationResultState

interface Validate {
    fun execute(text: String): ValidationResultState
}