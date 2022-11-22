package com.example.art_space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art_space.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtworkSpace()
            }
        }
    }
}

@Composable
fun ArtworkSpace(){

    var curPosition by remember { mutableStateOf(0)}

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 2.dp, bottom = 8.dp, start = 24.dp, end = 24.dp)
        ) {
            when(curPosition){
                0 ->{
                    CardImage(R.drawable.lemon_tree, title = "lemon_tree", subject = "google")
                }
                1 ->{
                    CardImage(R.drawable.lemon_squeeze, title = "lemon_squeeze", subject = "google")
                }
                2 ->{
                    CardImage(R.drawable.lemon_drink, title = "lemon_drink", subject = "google")
                }
                3 ->{
                    CardImage(R.drawable.lemon_restart, title = "lemon_restart", subject = "google")
                }
            }
            
            Spacer(modifier = Modifier.height(4.dp))
            PreviousNext(curPosition){ it->
                curPosition = it
            }
        }

}

@Composable
fun PreviousNext(position: Int, modifier: Modifier = Modifier, changePosition: (Int)->Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 36.dp, end = 36.dp)
        .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            onClick = {
                if(position==0) changePosition(3)
                else changePosition(position-1)
            },
            modifier = modifier
                .padding(8.dp)
                .weight(1f)
        ) {
            Text(text = stringResource(R.string.btn_previous))
        }

        Button(
            onClick = {
                if(position==3) changePosition(0)
                else changePosition(position+1)
            },
            modifier = modifier
//                .fillMaxWidth()
//                .wrapContentWidth(Alignment.End)
                .padding(8.dp)
                .weight(1f)
        ){
            Text(text = stringResource(id = R.string.btn_next))
        }
    }/////////////////////////////
}

@Composable
fun CardImage(drawableId: Int, title: String, subject: String){
    Column() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 36.dp, end = 36.dp)
                .border(2.dp, Color.DarkGray)
        ) {
            Image(
                painter = painterResource(drawableId),
                contentDescription = "",
                modifier = Modifier
                    .padding(36.dp)
                    .border(0.2.dp, Color.LightGray)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Card(
//            border = BorderStroke(2.3.dp, Color.LightGray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 36.dp, end = 36.dp),
            elevation = 12.dp

        ) {
            Column(modifier = Modifier.padding(top = 12.dp, bottom = 8.dp)) {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = subject,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtworkSpace()
    }
}