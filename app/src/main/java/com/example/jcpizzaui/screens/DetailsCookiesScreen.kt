package com.example.jcpizzaui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcpizzaui.models.CookiesData

@Composable
fun DetailsCookiesScreen(
    cookiesList: List<CookiesData>,
    item: Int?,
    modifier: Modifier = Modifier,
) {

    val context = LocalContext.current

    Surface(
        modifier.fillMaxSize(),
        color = Color.DarkGray
    ) {

    }

    Box(
        modifier
            .width(250.dp)
            .padding(horizontal = 70.dp),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier
                .padding(10.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(Color(0xFF3D3434))

        ) {

            Column(
                modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = cookiesList[item!!].image,
                    contentDescription = "",
                    modifier = Modifier
                        .size(130.dp)
                        .padding(start = 16.dp)
                        .clip(CircleShape),
                )

                Spacer(modifier = modifier.height(10.dp))

                Text(
                    text = cookiesList[item].name,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = modifier.height(10.dp))

                Row(
                    modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {


                    Button(
                        onClick = {
                            Toast.makeText(context, "Add to cart", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xffe38035)),

                        ) {
                        Text(
                            text = "Buy",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.White
                        )
                    }

                    Text(
                        text = cookiesList[item].currentPrice,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    )


                }
            }
        }
    }
}
