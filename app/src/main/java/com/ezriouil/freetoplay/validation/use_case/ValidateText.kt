package com.ezriouil.freetoplay.validation.use_case

import com.ezriouil.freetoplay.validation.interfaces.Validate
import com.ezriouil.freetoplay.validation.state.ValidationResultState

class ValidateText : Validate {
    override fun execute(text: String): ValidationResultState {
        return if (text.isBlank()) {
            ValidationResultState(isValid = false, errorMsg = "the field can't be blank")
        }
        else if (text.length < 6) {
            ValidationResultState(isValid = false, errorMsg = "the field must be more 6 characters")
        }
        else {
            ValidationResultState(isValid = true)
        }
    }
}