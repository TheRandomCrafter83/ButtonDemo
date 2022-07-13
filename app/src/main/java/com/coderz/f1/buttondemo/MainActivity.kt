package com.coderz.f1.buttondemo

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.coderz.f1.buttondemo.ui.theme.ButtonDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context:Context = LocalContext.current
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {

                        DoubleButton(
                            Color(0x23949494),
                            "Card",
                            "Bank",
                            Color(0xFF2F7D32),
                            buttonFocusOnClick = {
                                Toast.makeText(context,"Bank was clicked",Toast.LENGTH_SHORT).show()
                            },
                            buttonNonFocusOnClick = {
                                Toast.makeText(context,"Card was clicked",Toast.LENGTH_SHORT).show()
                            }
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun DoubleButton(mainBackgroundColor:Color,
                 buttonNonFocusText:String,
                 buttonFocusText:String,
                 buttonFocusColor:Color,
                 buttonNonFocusOnClick:()->Unit,
                 buttonFocusOnClick:()->Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)
        .clip(RoundedCornerShape(50))
        .background(mainBackgroundColor)
        .padding(0.dp)
    ) {
        Button(
            onClick =  buttonNonFocusOnClick ,
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            colors=ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = null
        ) {
            Text(buttonNonFocusText)
        }
        Button(
            onClick =  buttonFocusOnClick ,
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(backgroundColor = buttonFocusColor)

        ) {
            Text(buttonFocusText, color = Color.White)
        }
    }
}