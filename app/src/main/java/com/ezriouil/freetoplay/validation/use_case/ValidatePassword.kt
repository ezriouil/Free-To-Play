package com.ezriouil.freetoplay.validation.use_case

import com.ezriouil.freetoplay.validation.interfaces.Validate
import com.ezriouil.freetoplay.validation.state.ValidationResultState

class ValidatePassword : Validate {

    override fun execute(text: String): ValidationResultState {

        val isValidateTheField = text.any { it.isDigit() } && text.any { it.isLetter() }

        return if (text.isBlank()) {
            ValidationResultState(isValid = false, errorMsg = "the field can't be blank")
        } else if (text.length < 8) {
            ValidationResultState(isValid = false, errorMsg = "the password must be 8 characters")
        } else if (!isValidateTheField) {
            ValidationResultState(isValid = false, errorMsg = "the password must be letters and digits ")
        } else {
            ValidationResultState(isValid = true)
        }
    }
}