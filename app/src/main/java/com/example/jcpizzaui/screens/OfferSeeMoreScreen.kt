package com.example.jcpizzaui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jcpizzaui.R
import com.example.jcpizzaui.models.CookiesData

@Composable
fun OfferSeeMoreScreen(
    navController: NavController,
    cookieOffersList: List<CookiesData>,
    modifier: Modifier = Modifier,
) {

    LazyVerticalGrid(
        modifier = modifier
            .background(Color.DarkGray),
        columns = GridCells.Adaptive(160.dp),
        content = {
            items(cookieOffersList.size) {
                CardOfferBuilderSeeMore(
                    navController = navController,
                    item = it,
                    cookieOffersList = cookieOffersList
                )
            }
        })
}

@Composable
fun CardOfferBuilderSeeMore(
    modifier: Modifier = Modifier,
    navController: NavController,
    item: Int,
    cookieOffersList: List<CookiesData>,
) {
    Box(
        modifier
            .wrapContentSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter,
    ) {

        Card(
            modifier
                .padding(top = 80.dp)
                .height(150.dp)
                .clickable { navController.navigate("${Screens.DetailsOffers.route}?item=$item") }
                .width(160.dp),
            colors = CardDefaults.cardColors(Color(0xFF3D3434)),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {

            Column(
                modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, top = 30.dp, end = 10.dp, bottom = 10.dp)
            ) {

                // Title
                Text(
                    text = cookieOffersList[item].name,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif,
                    maxLines = 2
                )

                Row(
                    modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Icon(
                        modifier = modifier
                            .size(25.dp),
                        painter = painterResource(id = R.drawable.premium),
                        contentDescription = "",
                        tint = Color(0xffe38035)
                    )

                    Text(
                        text = "Premium",
                        fontSize = 14.sp,
                        color = Color(0xffe38035),
                        fontFamily = FontFamily.Serif
                    )
                }

                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    cookieOffersList[item].normalPrice?.let {
                        Text(
                            text = it,
                            color = Color.Red,
                            fontSize = 18.sp,
                            textDecoration = TextDecoration.LineThrough,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Text(
                        text = cookieOffersList[item].currentPrice,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    )

                }
            }

        }
        Image(
            painter = cookieOffersList[item].image, contentDescription = "",
            modifier
                .size(110.dp)
                .clip(CircleShape),


            )
    }

}