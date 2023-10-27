@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.loginapp

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginapp.ui.theme.LoginAppTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    loginPage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loginPage() {
    var username = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.design_ic_visibilitiy_off)
    } else
        painterResource(id = R.drawable.design_ic_visibility)

    Column(

        Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,



    ) {

        Box(Modifier.padding(0.dp,18.dp)) {
            OutlinedTextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text(text = "Username") },
                colors = TextFieldDefaults.textFieldColors(
                    Color.Black,
                    focusedIndicatorColor = Color.Magenta,
                    )
            )
        }
        
        OutlinedTextField(
            value = password.value,
            onValueChange ={ password.value = it},
            label = { Text(text = "Password") },
            colors = TextFieldDefaults.textFieldColors(
                Color.Black,
                focusedIndicatorColor = Color.Magenta
            ),
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter= icon,
                        contentDescription ="Show/Hide Password"
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()

        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(Modifier.padding(10.dp,25.dp)) {
                Button(
                    onClick = { Log.e("Button", "Login succesful") },
                    modifier = Modifier.size(120.dp,40.dp)
                    ) {
                    Text(
                        text = "Login",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif,


                            )
                    )


                }
            }
            Box(modifier = Modifier.padding(10.dp,25.dp)) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(120.dp, 40.dp)
                ) {
                    Text(
                        text = "Register",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif
                        )
                    )

                }
            }

        }
        






    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    loginPage()
    }
