package com.ezriouil.freetoplay.presentation.view_model.auth.sing_in

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezriouil.freetoplay.utils.TextFieldType
import com.ezriouil.freetoplay.validation.event.ValidationEvent
import com.ezriouil.freetoplay.validation.event.ValidationResultEvent
import com.ezriouil.freetoplay.validation.state.ValidationState
import com.ezriouil.freetoplay.validation.use_case.ValidateEmail
import com.ezriouil.freetoplay.validation.use_case.ValidatePassword
import com.ezriouil.freetoplay.validation.use_case.ValidateText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class BaseValidationViewModel @Inject constructor() : ViewModel() {

    val forms = mutableStateMapOf<TextFieldType, ValidationState>()
    private val _validationEvent = Channel<ValidationResultEvent>()
    val validationEvent = _validationEvent.receiveAsFlow()

    fun onEvent(event: ValidationEvent) {
        when (event) {
            is ValidationEvent.TextFieldValueChange -> {
                val validate = when (event.validationState.textFieldType) {

                    TextFieldType.TEXT -> { ValidateText() }

                    TextFieldType.EMAIL -> { ValidateEmail() }

                    TextFieldType.PASSWORD -> { ValidatePassword() }

                }
                val result = validate.execute(event.validationState.text.trim())

                forms[event.validationState.textFieldType] = if (result.isValid) {
                    event.validationState.copy(hasError = false, errorMsg = null)
                } else {
                    event.validationState.copy(hasError = true, errorMsg = result.errorMsg)
                }
            }
            ValidationEvent.Submit -> {
                isValidForm()
            }
        }
    }

    private fun isValidForm() {
        var isValid = true
        for (validationState in forms.values) {
            onEvent(event = ValidationEvent.TextFieldValueChange(validationState = validationState))
            if (validationState.isRequired && validationState.hasError) {
                isValid = false
            }
        }
        if (isValid) {
            viewModelScope.launch {
                _validationEvent.send(element = ValidationResultEvent.Success)
            }
        }
    }

}