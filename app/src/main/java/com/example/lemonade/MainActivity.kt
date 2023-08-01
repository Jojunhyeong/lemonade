package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {

    var presentImage by remember { mutableStateOf(1) }
    var clickCount by remember {mutableStateOf(0)}
    var count = 3
    // A surface container using the 'background' color from the theme
    Surface(

        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (presentImage) {
            1 -> Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(text = stringResource(R.string.lemon_select), fontSize = 18.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(R.drawable.lemon_tree), contentDescription = stringResource(
                    R.string.lemon_tree_content_description),
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable { presentImage = 2 }
                        .border(width = 4.dp, color = Color(105,205,216), shape = RoundedCornerShape(4.dp))
                )
                
            }
            
            2 -> Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(text = stringResource(R.string.lemon_squeeze), fontSize = 18.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(R.drawable.lemon_squeeze), contentDescription = stringResource(
                    R.string.lemon_content_description),
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            clickCount++
                            if (clickCount == count) {
                                presentImage = 3
                            }

                        } .border(width = 4.dp, color = Color(105,205,216), shape = RoundedCornerShape(4.dp))
                        )
            }

            3 -> Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(text = stringResource(R.string.lemon_drink), fontSize = 18.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(R.drawable.lemon_drink), contentDescription = stringResource(
                    R.string.glass_of_lemonade_content_description), modifier = Modifier
                    .wrapContentSize()
                    .clickable { presentImage = 4 }
                    .border(width = 4.dp, color = Color(105,205,216), shape = RoundedCornerShape(4.dp)))

                
            }
            
            4 -> Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(text = stringResource(R.string.lemon_empty_glass), fontSize = 18.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(R.drawable.lemon_restart), contentDescription = stringResource(
                    R.string.empty_glass_content_description
                ), modifier = Modifier
                    .wrapContentSize()
                    .clickable { presentImage = 1 }
                    .border(width = 4.dp, color = Color(105,205,216), shape = RoundedCornerShape(4.dp)))
                
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}




