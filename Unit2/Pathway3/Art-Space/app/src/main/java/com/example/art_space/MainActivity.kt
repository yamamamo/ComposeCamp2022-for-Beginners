package com.example.art_space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 2.dp, bottom = 8.dp, start = 24.dp, end = 24.dp)
        ) {
            when(curPosition){
                0 ->{
                    CardImage(R.drawable.lemon_tree)
                }
                0 ->{
                    CardImage(R.drawable.lemon_squeeze)
                }
                0 ->{
                    CardImage(R.drawable.lemon_drink)
                }
                0 ->{
                    CardImage(R.drawable.lemon_restart)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            PreviousNext(3){ it->

            }
        }

}
///Modifier 어딨어요
@Composable
fun PreviousNext(position: Int, modifier: Modifier = Modifier, changePosition: (Int)->Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(onClick = {},
            modifier = modifier
                .wrapContentWidth(Alignment.Start)
        ) {
            Text(text = stringResource(R.string.btn_previous))
        }

        Button(onClick = {},
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        ){
            Text(text = stringResource(id = R.string.btn_next))
        }
    }
}

@Composable
fun CardImage(drawableId: Int){
    Card(
        modifier = Modifier
            .padding(top = 2.dp, bottom = 8.dp, start = 24.dp, end = 24.dp)
    ) {
        Image(
            painter = painterResource(drawableId),
            contentDescription = ""
        )
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtworkSpace()
    }
}