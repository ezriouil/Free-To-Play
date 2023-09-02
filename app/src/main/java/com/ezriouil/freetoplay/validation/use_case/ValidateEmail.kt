package com.ezriouil.freetoplay.validation.use_case

import android.util.Patterns
import com.ezriouil.freetoplay.validation.interfaces.Validate
import com.ezriouil.freetoplay.validation.state.ValidationResultState

class ValidateEmail : Validate {

    override fun execute(text: String): ValidationResultState {

        return if (text.isBlank()) {
            ValidationResultState(isValid = false, errorMsg = "the field can't be blank")
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
            ValidationResultState(isValid = false, errorMsg = "this is not a valid email")
        }
        else {
            ValidationResultState(isValid = true)
        }
    }
}