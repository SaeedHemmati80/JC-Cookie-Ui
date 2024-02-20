package com.example.jcpizzaui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jcpizzaui.R
import com.example.jcpizzaui.models.CookiesData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PremiumScreen(
    navController: NavController,
    cookiesList: List<CookiesData>,
    modifier: Modifier = Modifier,
) {
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(scrollBehavior = scrollBehavior)
        },
        content = { paddingValues ->

            val scrollState = rememberScrollState()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(scrollState)
                    .background(Color.DarkGray)
            ) {
                CookiesSection(navController = navController)
                PremiumCookieCard(navController = navController, cookiesList = cookiesList)
                Spacer(modifier = modifier.height(20.dp))
                OffersSection()
            }

        },
        bottomBar = {
            NavBar()
        },
        containerColor = Color.DarkGray
    )

}

@Composable
fun OffersSection() {
    OffersLabel()
    CookieOffers()
}

@Composable
fun CookieOffers(modifier: Modifier = Modifier) {
    val cookieOffersList = listOf(
        CookiesData(
            image = painterResource(id = R.drawable.cookie3),
            name = "Oatmeal \nCookie",
            normalPrice = "20 $",
            currentPrice = "14 $"
        ), CookiesData(
            image = painterResource(id = R.drawable.cookie7),
            name = "Peanut \nCookie",
            normalPrice = "21 $",
            currentPrice = "14 $"
        ), CookiesData(
            image = painterResource(id = R.drawable.cookie8),
            name = "Walnut \nCookie",
            normalPrice = "22 $",
            currentPrice = "15 $"
        ), CookiesData(
            image = painterResource(id = R.drawable.cookie9),
            name = "Raisins \nCookie",
            normalPrice = "18 $",
            currentPrice = "14 $"
        )
    )

    LazyRow(
        modifier
            .fillMaxWidth()
            .padding(start = 20.dp),
        content = {
            items(cookieOffersList.size) {
                cookieOffersList[it].normalPrice?.let { normalPrice ->
                    OffersCardBuilder(
                        image = cookieOffersList[it].image,
                        name = cookieOffersList[it].name,
                        normalPrice = normalPrice,
                        currentPrice = cookieOffersList[it].currentPrice
                    )
                }
            }
        }
    )
}

@Composable
fun OffersCardBuilder(
    modifier: Modifier = Modifier,
    image: Painter,
    name: String,
    normalPrice: String,
    currentPrice: String,
) {
    Box(
        modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier
                .fillMaxWidth()
                .height(150.dp)
                .aspectRatio(2.3f),
            colors = CardDefaults.cardColors(Color(0xFF3D3434)),
            shape = RoundedCornerShape(25.dp, 25.dp, 90.dp, 25.dp),
            elevation = CardDefaults.cardElevation(10.dp)

        ) {
            Row(
                modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(start = 16.dp)
                        .clip(CircleShape),
                    painter = image,
                    contentDescription = "",
                )

                // Col 1
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = name,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        maxLines = 2
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
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
                }

                // Col2
                Column(
                    modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {

                    Text(
                        text = normalPrice,
                        color = Color.Red,
                        fontSize = 18.sp,
                        textDecoration = TextDecoration.LineThrough,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = currentPrice,
                        color = Color.White,
                        fontSize = 22.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        }
    }
}

@Composable
fun OffersLabel(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(
            text = "Offers",
            fontSize = 32.sp,
            color = Color.White,
            fontFamily = FontFamily.Serif
        )

        Text(
            text = "See more",
            fontSize = 12.sp,
            color = Color(0xffe38035),
            fontFamily = FontFamily.Serif
        )
    }
}

@Composable
fun PremiumCookieCard(
    modifier: Modifier = Modifier,
    navController: NavController,
    cookiesList: List<CookiesData>,
) {

    LazyRow(
        modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 16.dp)
    ) {
        items(cookiesList.size) {
            CardBuilder(
                navController = navController,
                item = it,
                cookiesList = cookiesList
            )
        }
    }
}


@Composable
fun CardBuilder(
    modifier: Modifier = Modifier,
    navController: NavController,
    item: Int,
    cookiesList: List<CookiesData>,
) {
    Box(
        modifier
            .wrapContentSize()
            .padding(start = 6.dp, end = 20.dp),
        contentAlignment = Alignment.TopCenter,
    ) {

        Card(
            modifier
                .padding(top = 80.dp)
                .height(150.dp)
                .clickable { navController.navigate(Screens.Details.route + "?item=$item") }
                .width(160.dp),
            colors = CardDefaults.cardColors(Color(0xFF3D3434)),
            shape = RoundedCornerShape(25.dp, 25.dp, 90.dp, 25.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {

            Column(
                modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, top = 30.dp, end = 10.dp, bottom = 10.dp)
            ) {

                // Title
                Text(
                    text = cookiesList[item].name,
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
                Text(
                    text = cookiesList[item].currentPrice,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
            }

        }
        Image(
            painter = cookiesList[item].image, contentDescription = "",
            modifier
                .clip(CircleShape)
                .size(110.dp)

        )

        Image(
            painter = painterResource(id = R.drawable.arrow_forward_24),
            contentDescription = "",
            modifier
                .size(45.dp)
                .clip(CircleShape)
                .align(Alignment.BottomEnd)
                .background(Color(0xffe38035)),
            colorFilter = ColorFilter.tint(Color(0xff292929))
        )
    }


}

@Composable
fun CookiesSection(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                modifier = modifier
                    .size(35.dp),
                painter = painterResource(id = R.drawable.premium),
                contentDescription = "",
                tint = Color(0xffe38035)
            )

            Text(
                text = "Premium",
                fontSize = 24.sp,
                color = Color(0xffe38035),
                fontFamily = FontFamily.Serif
            )
        }

        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = "Cookies",
                fontSize = 32.sp,
                color = Color.White,
                fontFamily = FontFamily.Serif
            )

            Text(
                modifier = modifier
                    .clickable {
                               navController.navigate(Screens.SeeMore.route)
                    },
                text = "See more",
                fontSize = 12.sp,
                color = Color(0xffe38035),
                fontFamily = FontFamily.Serif
            )
        }

        Spacer(modifier = modifier.height(8.dp))


    }
}

@Composable
fun NavBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 36.dp,
                    topEnd = 36.dp,
                    bottomStart = 18.dp,
                    bottomEnd = 18.dp
                )
            ),
        containerColor = Color(0xff292929),
        contentColor = Color(0xffe38035),
        content = {

            //Home
            NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home",
                    tint = Color(0xffe38035)
                )
            },
                label = { Text(text = "Home", color = Color(0xffe38035)) })

            //Cart
            NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
                Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = "Cart",
                    tint = Color(0xffe38035)
                )
            },
                label = { Text(text = "Cart", color = Color(0xffe38035)) })

            // Search
            NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search",
                    tint = Color(0xffe38035)
                )
            },
                label = { Text(text = "Search", color = Color(0xffe38035)) })
        }
    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier, scrollBehavior: TopAppBarScrollBehavior) {
    CenterAlignedTopAppBar(
        modifier = modifier
            .wrapContentSize()
            .padding(6.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 18.dp,
                    topEnd = 18.dp,
                    bottomStart = 32.dp,
                    bottomEnd = 32.dp
                )
            ),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color(0xff292929)),
        title = {
            Text(
                text = "Cookie Shop",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        },
        navigationIcon = {
            Image(
                modifier = modifier
                    .padding(start = 8.dp)
                    .size(38.dp),
                colorFilter = ColorFilter.tint(Color(0xffe38035)),
                imageVector = Icons.Filled.Menu,
                contentDescription = ""
            )
        },
        actions = {
            Image(
                painter = painterResource(id = R.drawable.shopping_bag_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xffe38035))
                    .padding(5.dp),
                colorFilter = ColorFilter.tint(Color(0xff292929))


            )
        },
        scrollBehavior = scrollBehavior
    )
}

