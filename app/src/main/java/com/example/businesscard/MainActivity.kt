package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color(210, 232, 212)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        CenterSection(modifier = Modifier.align(Alignment.Center))
        BottomSection(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun CenterSection(modifier: Modifier = Modifier) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            color = Color(0xFF073042),
            modifier = Modifier
                .size(100.dp)
        ) {
            val image = painterResource(id = R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = null,
                modifier = modifier.scale(0.9F)
            )
        }

        Text(
            text = stringResource(R.string.name),
            fontSize = 32.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_light)),
            modifier = modifier.padding(vertical = 8.dp)
        )

        Text(
            text = stringResource(R.string.title),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF006a37)
        )
    }
}

@Composable
fun Icons(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(start = 72.dp, bottom = 32.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_phone_24),
            contentDescription = stringResource(id = R.string.phone_number_description)
        )

        Image(
            painter = painterResource(id = R.drawable.baseline_share_24),
            contentDescription = stringResource(id = R.string.instagram_handle_description),
            modifier = modifier.padding(top = 16.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.baseline_email_24),
            contentDescription = stringResource(id = R.string.email_address_description),
            modifier = modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun Info(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(bottom = 32.dp, end = 40.dp)
    ) {
        Text(
            text = stringResource(id = R.string.phone_number)
        )

        Text(
            text = stringResource(id = R.string.instagram_handle),
            modifier = modifier.padding(top = 16.dp)
        )

        Text(
            text = stringResource(id = R.string.email_address),
            modifier = modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun BottomSection(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {
        Icons(Modifier.align(Alignment.CenterStart))
        Info(Modifier.align(Alignment.CenterEnd))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}