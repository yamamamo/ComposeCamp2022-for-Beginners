package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val image = painterResource(id = R.drawable.bg_compose_background)
            val title = getString(R.string.title_jetpack_compose_tutorial)
            val shortDescription = getString(R.string.compose_short_desc)
            val longDescription = getString(R.string.compose_long_desc)

            ArticleCard(
                title = title,
                shortDescription = shortDescription,
                longDescription = longDescription,
                imagePainter = image
            )
        }
    }
}

@Composable
fun ComposeArticleApp() {
}

@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Column() {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )

        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = shortDescription,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 0.dp,
                    bottom = 0.dp
                ),
            textAlign = TextAlign.Justify //줄 바꿈이 일어날 때 이전 줄을 가득 채우도록 글자간 폭을 조정
        )
        Text(
            text = longDescription,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArticleCard(
        title = "자 드가자",
        shortDescription = "출발하자",
        longDescription = "자 드가자. 출발하자. 자리하자", 
        imagePainter = painterResource(id = R.drawable.bg_compose_background)
    )
}