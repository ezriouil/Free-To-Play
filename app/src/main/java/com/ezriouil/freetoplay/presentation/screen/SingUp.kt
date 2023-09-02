package com.ezriouil.freetoplay.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ezriouil.freetoplay.presentation.component.auth.CustomButton
import com.ezriouil.freetoplay.presentation.component.auth.CustomTextField
import com.ezriouil.freetoplay.presentation.view_model.auth.sing_in.SingUpViewModel
import com.ezriouil.freetoplay.utils.ManageScreen
import com.ezriouil.freetoplay.utils.TextFieldType
import com.ezriouil.freetoplay.validation.event.ValidationEvent
import com.ezriouil.freetoplay.validation.event.ValidationResultEvent

@Composable
fun SingUp(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {

    val viewModel: SingUpViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        viewModel.validationEvent.collect {
            when (it) {
                ValidationResultEvent.Success -> {
                    navHostController.navigate(ManageScreen.SingInScreen.route)
                }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //signIn
        Text(
            text = stringResource(R.string.sing_up),
            color = Color.White,
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = modifier.height(22.dp))
        CustomTextField(
            state = viewModel.forms[TextFieldType.TEXT]!!,
            onValueChange = {
                viewModel.onEvent(
                    event = ValidationEvent.TextFieldValueChange(
                        viewModel.forms[TextFieldType.TEXT]!!.copy(text = it)
                    )
                )
            },
            label = stringResource(R.string.full_name),
            type = TextFieldType.TEXT,
            textFieldColors = Color.White,
            backgroundColor = Color.Black,
        )
        Spacer(modifier = modifier.height(22.dp))
        CustomTextField(
            state = viewModel.forms[TextFieldType.EMAIL]!!,
            onValueChange = {
                viewModel.onEvent(
                    event = ValidationEvent.TextFieldValueChange(
                        viewModel.forms[TextFieldType.EMAIL]!!.copy(text = it)
                    )
                )
            },
            label = stringResource(R.string.email),
            type = TextFieldType.EMAIL,
            textFieldColors = Color.White,
            backgroundColor = Color.Black,
        )
        Spacer(modifier = modifier.height(8.dp))
        CustomTextField(
            state = viewModel.forms[TextFieldType.PASSWORD]!!,
            onValueChange = {
                viewModel.onEvent(
                    event = ValidationEvent.TextFieldValueChange(
                        viewModel.forms[TextFieldType.PASSWORD]!!.copy(text = it)
                    )
                )
            },
            label = stringResource(R.string.password),
            type = TextFieldType.PASSWORD,
            textFieldColors = Color.White,
            backgroundColor = Color.Black
        )
        Spacer(modifier = modifier.height(22.dp))
        CustomButton(
            onClick = { viewModel.onEvent(event = ValidationEvent.Submit) },
            text = stringResource(R.string.ok)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "I have already account !!",
                color = Color.White,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = stringResource(R.string.sing_in),
                color = Color.White,
                style = MaterialTheme.typography.h5,
                textDecoration = TextDecoration.Underline,
                modifier = modifier
                    .clickable { navHostController.navigate(ManageScreen.SingInScreen.route) }
            )
        }
    }
}