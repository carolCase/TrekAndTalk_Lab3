package components

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff



@Composable
fun EmailInputTextField(labelValue: String,
                painterResource: Painter, //onTextSelected: (String)-> Unit,
                /*errorStatus:Boolean = false*/) {
    val email = remember { mutableStateOf("") }


    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        value = email.value,
        colors = OutlinedTextFieldDefaults.colors(
            //errorTextColor = Color.Red,
            cursorColor = Color.Black,
            focusedBorderColor = Color.DarkGray,
            focusedLabelColor = Color.LightGray
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        onValueChange = {
            email.value = it
          // onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
       // isError = !errorStatus

    )
}


@Composable
fun UserNameTextField(labelValue: String,
                painterResource: Painter, //onTextSelected: (String)-> Unit,
                /*errorStatus:Boolean = false*/) {
    val userName = remember { mutableStateOf("") }


    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        value = userName.value,
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color.Black,
            focusedBorderColor = Color.DarkGray,
            focusedLabelColor = Color.LightGray
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = {
            userName.value = it
           // onTextSelected(it)
                        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
       // isError = !errorStatus

    )
}

@Composable
fun PasswordTextField(labelValue: String,painterResource: Painter,//onTextSelected: (String) -> Unit
                     /* errorStatus: Boolean = false*/) {
    val password = remember { mutableStateOf("") }
    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        value = password.value,
        colors = OutlinedTextFieldDefaults.colors(
            errorTextColor = Color.Red,
            cursorColor = Color.Black,
            focusedBorderColor = Color.DarkGray,
            focusedLabelColor = Color.LightGray
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)  ,
        onValueChange = {
            password.value = it
           // onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
       // isError = !errorStatus,

        trailingIcon = {
            val iconImage = if(passwordVisible.value){
                Icons.Filled.Visibility
            } else{
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisible.value){
                "hide password"
            } else {
                "show password"
            }

            IconButton(onClick = {passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription =description )
            }

        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation()

    )
}