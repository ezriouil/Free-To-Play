package com.ezriouil.freetoplay.presentation.view_model.auth.sing_in

import com.ezriouil.freetoplay.utils.TextFieldType
import com.ezriouil.freetoplay.validation.state.ValidationState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingInViewModel @Inject constructor() : BaseValidationViewModel() {

    private val emailValidationState =
        ValidationState(textFieldType = TextFieldType.EMAIL)

    private val passwordValidationState =
        ValidationState(textFieldType = TextFieldType.PASSWORD)


    init {
        this.forms[TextFieldType.EMAIL] = emailValidationState
        this.forms[TextFieldType.PASSWORD] = passwordValidationState
    }
}