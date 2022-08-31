package com.zvonimirplivelic.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zvonimirplivelic.composearticle.R.drawable.*
import com.zvonimirplivelic.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticle(
                        getString(R.string.article_title),
                        getString(R.string.article_description),
                        getString(R.string.article_detail)
                    )
                }
            }
        }
    }
}


@Composable
fun ComposeArticle(title: String, description: String, details: String) {
    val image = painterResource(bg_compose_background)
    Box {
        Column() {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
            Text(
                text = title,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            )
            Text(
                text = description,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)

            )
            Text(
                text = details,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun ArticlePreview() {
    ComposeArticleTheme() {
        ComposeArticle(
            stringResource(id = R.string.article_title),
            stringResource(id = R.string.article_description),
            stringResource(R.string.article_detail)
        )
    }
}