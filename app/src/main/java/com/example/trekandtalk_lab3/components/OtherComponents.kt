package com.example.trekandtalk_lab3.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trekandtalk_lab3.R
import com.example.trekandtalk_lab3.navigation.Screen


@Composable
fun DividerComponent() {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )

        Text(text = "or register with",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(8.dp))

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )
    }
}

@Composable
fun CheckboxComponent(value: String) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value,
            onCheckedChange = {
                    newValue ->
                checkedState.value = newValue


            })

        Text(text = value, color = Color.LightGray)

    }
}

@Composable
fun ClickableTextSignUp(value: String) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraLight,
                fontStyle = FontStyle.Normal),
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable {Screen.NavigationRouter.navigateTo(Screen.LoginScreen)}

        )
    }
}
@Composable
fun DropDownMenuLanguage() {
    val selectLanguage = remember { mutableStateOf("Language") }
    val dropDownStatus = remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable() {
                dropDownStatus.value = !dropDownStatus.value
            }
        ) {
            Text(text = selectLanguage.value)
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                contentDescription = "DropDown Icon"
            )
        }

        DropdownMenu(
            expanded = dropDownStatus.value,
            onDismissRequest = { dropDownStatus.value = false }
        ) {

            DropdownMenuItem(text = { Text(text = "Spanish")},
                onClick = { dropDownStatus.value = false
                    selectLanguage.value = "Spanish"})



            DropdownMenuItem(text = { Text(text = "Portuguese")},
                onClick = { dropDownStatus.value = false
                    selectLanguage.value = "Portuguese"})



            DropdownMenuItem(text = { Text(text = "English") },
                onClick = { dropDownStatus.value = false
                    selectLanguage.value = "English"})


        }
    }
}

@Composable
fun ClickableTextGoToProfile(value: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal
            ),
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable(onClick = { Screen.NavigationRouter.navigateTo(Screen.SavedTranslationScreen) })
        )
    }
}



