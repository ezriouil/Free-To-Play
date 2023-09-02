package com.ezriouil.freetoplay.presentation.view_model.auth.sing_in

import com.ezriouil.freetoplay.utils.TextFieldType
import com.ezriouil.freetoplay.validation.state.ValidationState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingUpViewModel @Inject constructor() : BaseValidationViewModel() {

    private val fullName = ValidationState(textFieldType = TextFieldType.TEXT)
    private val email = ValidationState(textFieldType = TextFieldType.EMAIL)
    private val password = ValidationState(textFieldType = TextFieldType.PASSWORD)

    init {
        this.forms[TextFieldType.TEXT] = fullName
        this.forms[TextFieldType.EMAIL] = email
        this.forms[TextFieldType.PASSWORD] = password
    }
}