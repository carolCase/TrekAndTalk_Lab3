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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trekandtalk_lab3.R
import com.example.trekandtalk_lab3.ui.theme.DarkWhite
import com.example.trekandtalk_lab3.components.ClickableTextSignUp
import com.example.trekandtalk_lab3.components.HeadLine2Text
import com.example.trekandtalk_lab3.components.PasswordTextField
import com.example.trekandtalk_lab3.components.StandardButton
import com.example.trekandtalk_lab3.components.UserNameTextField

@Composable
fun LoginScreen() {
    Surface(
        color = DarkWhite,
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp))
    {
        Column( modifier = Modifier
            .background(DarkWhite)
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
            UserNameTextField(labelValue = "name", painterResource = painterResource(id = R.drawable.baseline_account_circle_24))

            PasswordTextField(labelValue = "password", painterResource = painterResource(id = R.drawable.baseline_password_24))
            ClickableTextSignUp(value = " Forgot password" )

            Spacer(modifier = Modifier.height(26.dp))

            StandardButton(value = "Login", onButtonClicked = { /*TODO*/ })











        }







    }
}

@Preview
@Composable
fun Loginpreview() {
    LoginScreen()
}