package com.example.trekandtalk_lab3.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import com.example.trekandtalk_lab3.R
import com.example.trekandtalk_lab3.components.AuthButton
import com.example.trekandtalk_lab3.ui.theme.DarkWhite
import com.example.trekandtalk_lab3.components.ClickableTextSignUp
import com.example.trekandtalk_lab3.components.EmailInputTextField
import com.example.trekandtalk_lab3.components.HeadLine2Text
import com.example.trekandtalk_lab3.components.PasswordTextField


import com.example.trekandtalk_lab3.data.uievents.LoginUIEvent

import com.example.trekandtalk_lab3.data.viewmodels.LoginViewModel

import com.example.trekandtalk_lab3.navigation.Screen

@Composable
fun LoginScreen(loginViewModel:LoginViewModel) {
    Surface(
        color = DarkWhite,
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp))

    {
        Column( modifier = Modifier
            .background(DarkWhite)
            .verticalScroll(state = rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
        {

            Image(painter = painterResource(id = R.drawable.hikers),
                contentDescription = "",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(width = 250.dp, height = 250.dp))


            HeadLine2Text(value = "Login")
            Spacer(modifier = Modifier.height(26.dp))
            EmailInputTextField(labelValue = "email",
                painterResource = painterResource(id = R.drawable.baseline_email_24),
                onTextSelected = {loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))},
                errorStatus = loginViewModel.loginUIState.value.emailError)

            PasswordTextField(labelValue = "password",
                painterResource = painterResource(id = R.drawable.baseline_password_24),
                onTextSelected = {loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))},
                errorStatus = loginViewModel.loginUIState.value.passwordError)
            ClickableTextSignUp(value = " Forgot password" )

            Spacer(modifier = Modifier.height(26.dp))

            AuthButton(value = "Login", onButtonClicked = {
             loginViewModel.onEvent(LoginUIEvent.LoginButton)
            },isEnabled = loginViewModel.allErrorHandlingPassed.value)
        }


           BackHandler {
           Screen.NavigationRouter.navigateTo(Screen.SignUpScreen)
           }




    }
}

