package com.example.trekandtalk_lab3.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import com.example.trekandtalk_lab3.R
import com.example.trekandtalk_lab3.components.AuthButton
import com.example.trekandtalk_lab3.ui.theme.DarkWhite
import com.example.trekandtalk_lab3.components.CheckboxComponent
import com.example.trekandtalk_lab3.components.ClickableTextSignUp
import com.example.trekandtalk_lab3.components.DividerComponent
import com.example.trekandtalk_lab3.components.EmailInputTextField
import com.example.trekandtalk_lab3.components.HeadLine2Text
import com.example.trekandtalk_lab3.components.PasswordTextField
import com.example.trekandtalk_lab3.components.SubHeadLineText
import com.example.trekandtalk_lab3.components.UserNameTextField
import com.example.trekandtalk_lab3.data.uievents.SignUpUIEvent

import com.example.trekandtalk_lab3.data.viewmodels.SignUpViewModel
import com.example.trekandtalk_lab3.ui.theme.MediumLightGreen


@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel) {
    Surface(
        color = DarkWhite,
        modifier = Modifier
            .fillMaxSize()
    ){
        Box(modifier = Modifier.padding(45.dp)) {

            Column(
                modifier = Modifier
                    .background(DarkWhite)
                    .verticalScroll(state = rememberScrollState())
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                SubHeadLineText(value = "Register new Account")
                HeadLine2Text(value = "Trek'n Talk")
                UserNameTextField(
                    labelValue = "name",
                    painterResource(id = R.drawable.baseline_account_circle_24),
                    onTextSelected = { signUpViewModel.onEvent(SignUpUIEvent.UserNameChanged(it)) },
                    errorStatus = signUpViewModel.signUpUIState.value.userNameError
                )

                EmailInputTextField(
                    labelValue = "email",
                    painterResource(id = R.drawable.baseline_email_24),
                    onTextSelected = { signUpViewModel.onEvent(SignUpUIEvent.EmailChanged(it)) },
                    errorStatus = signUpViewModel.signUpUIState.value.emailError
                )

                PasswordTextField(
                    labelValue = "password",
                    painterResource(id = R.drawable.baseline_password_24),
                    onTextSelected = { signUpViewModel.onEvent(SignUpUIEvent.PasswordChanged(it)) },
                    errorStatus = signUpViewModel.signUpUIState.value.passwordError
                )

                CheckboxComponent(value = "Accept Privacy Policy and Terms of Use")

                Spacer(modifier = Modifier.height(26.dp))

                AuthButton(value = "Sign Up", onButtonClicked = {

                    signUpViewModel.onEvent(SignUpUIEvent.RegisterButton)
                }, isEnabled = signUpViewModel.allErrorHandlingPassed.value)




                DividerComponent()
                Spacer(modifier = Modifier.height(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.google), contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(shape = CircleShape)
                )

                Spacer(modifier = Modifier.height(26.dp))
                ClickableTextSignUp(value = "Already have an account")

            }

        }


    }
}

