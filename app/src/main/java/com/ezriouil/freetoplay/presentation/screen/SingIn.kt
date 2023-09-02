package com.ezriouil.freetoplay.presentation.screen

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ezriouil.freetoplay.presentation.component.auth.CustomButton
import com.ezriouil.freetoplay.presentation.component.auth.CustomTextField
import com.ezriouil.freetoplay.presentation.view_model.auth.sing_in.SingInViewModel
import com.ezriouil.freetoplay.utils.ManageScreen
import com.ezriouil.freetoplay.utils.TextFieldType
import com.ezriouil.freetoplay.validation.event.ValidationEvent
import com.ezriouil.freetoplay.validation.event.ValidationResultEvent


@Composable
fun SingIn(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    val viewModel: SingInViewModel = hiltViewModel()

    /*
    LaunchedEffect(result) {
        when (result) {
            is Resource.Loading -> Unit
            is Resource.Error -> Log.d("TAG", (result as Resource.Error).error)
            is Resource.Success -> {
                if ((result as Resource.Success).data) {
                    navHostController.navigate(ManageUI.HomeScreen.route)
                }
            }
        }
    }
     */

    LaunchedEffect(context) {
        viewModel.validationEvent.collect {
            when (it) {
                ValidationResultEvent.Success -> {
                    Toast.makeText(
                        context,
                        "Success",
                        Toast.LENGTH_LONG
                    ).show()
                    navHostController.navigate(ManageScreen.HomeScreen.route)
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
            text = stringResource(R.string.sing_in),
            color = Color.White,
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
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
                text = "I don't have yet",
                color = Color.White,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = stringResource(R.string.sing_up),
                color = Color.White,
                style = MaterialTheme.typography.h5,
                textDecoration = TextDecoration.Underline,
                modifier = modifier
                    .clickable { navHostController.navigate(ManageScreen.SingUpScreen.route) }
            )
        }
    }
    /*
    if (result == Resource.Loading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            ) {
                CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .padding(25.dp)
                )
            }
        }
    }

     */
}