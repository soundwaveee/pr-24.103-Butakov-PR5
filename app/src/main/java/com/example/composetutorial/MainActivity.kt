package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                SportAppScreen()
            }
        }
    }
}

@Composable
fun SportAppScreen() {
    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFE5E5),
            Color(0xFFE60000)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 600.dp)
                .align(Alignment.TopCenter)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.Black, CircleShape)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            MenuButton(text = "Упражнения", onClick = { })
            Spacer(modifier = Modifier.height(16.dp))

            MenuButton(text = "Статистика", onClick = { })
            Spacer(modifier = Modifier.height(16.dp))

            MenuButton(text = "Помощь тренера", onClick = { })
            Spacer(modifier = Modifier.height(16.dp))

            MenuButton(text = "Подключить уст-во", onClick = { })
        }
    }
}

@Composable
fun MenuButton(
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(28.dp)
                .background(Color.Black, RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(name = "Phone", device = "spec:width=411dp,height=891dp", showBackground = true)
@Preview(name = "Tablet", device = "spec:width=1280dp,height=800dp", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewSportApp() {
    ComposeTutorialTheme {
        SportAppScreen()
    }
}