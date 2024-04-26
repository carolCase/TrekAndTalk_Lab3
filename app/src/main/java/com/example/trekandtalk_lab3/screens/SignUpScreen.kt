package com.example.trekandtalk_lab3.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trekandtalk_lab3.R
import com.example.trekandtalk_lab3.ui.theme.DarkWhite
import components.CheckboxComponent
import components.ClickableTextSignUp
import components.DividerComponent
import components.EmailInputTextField
import components.HeadLine2Text
import components.PasswordTextField
import components.StandardButton

import components.SubHeadLineText
import components.UserNameTextField

@Composable
fun SignUpScreen() {
    Surface(
        color = DarkWhite,
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp)
    ){
      Column(modifier = Modifier
          .background(DarkWhite)
          .fillMaxSize(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally)
      {
       SubHeadLineText(value = "Register new Account")
          HeadLine2Text(value = "Trek'n Talk")
        UserNameTextField(labelValue = "name", painterResource(id = R.drawable.baseline_account_circle_24))

          EmailInputTextField(labelValue = "email", painterResource(id = R.drawable.baseline_email_24))

        PasswordTextField(labelValue = "password", painterResource(id =  R.drawable.baseline_password_24))

          CheckboxComponent(value = "Accept Privacy Policy and Terms of Use")

          Spacer(modifier = Modifier.height(26.dp))

          StandardButton(value = "Sign Up", onButtonClicked = { /*TODO*/ })

          DividerComponent()
          Spacer(modifier = Modifier.height(30.dp))
          Image(painter = painterResource(id = R.drawable.google), contentDescription = "",
              modifier = Modifier
                  .size(100.dp)
                  .clip(shape = CircleShape))

          Spacer(modifier = Modifier.height(26.dp))
          ClickableTextSignUp(value = "Already have an account")

      }





    }
}

@Preview
@Composable
fun SignUpPreview() {
    SignUpScreen()
}