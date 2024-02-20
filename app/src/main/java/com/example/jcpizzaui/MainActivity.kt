package com.example.jcpizzaui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.jcpizzaui.models.CookiesData
import com.example.jcpizzaui.navigation.NavGraph
import com.example.jcpizzaui.ui.theme.JCPizzaUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCPizzaUiTheme {

                val cookiesList = listOf(
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie1),
                        name = "Chocolate\nChips",
                        currentPrice = "20 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie2),
                        name = "Double\nChocolate",
                        currentPrice = "18 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie4),
                        name = "Sugar Free",
                        currentPrice = "19 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie5),
                        name = "Diet Cookie",
                        currentPrice = "24 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie6),
                        name = "LowFat",
                        currentPrice = "21 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie1),
                        name = "Chocolate\nChips",
                        currentPrice = "20 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie2),
                        name = "Double\nChocolate",
                        currentPrice = "18 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie4),
                        name = "Sugar Free",
                        currentPrice = "19 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie5),
                        name = "Diet Cookie",
                        currentPrice = "24 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie6),
                        name = "LowFat",
                        currentPrice = "21 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie1),
                        name = "Chocolate\nChips",
                        currentPrice = "20 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie2),
                        name = "Double\nChocolate",
                        currentPrice = "18 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie4),
                        name = "Sugar Free",
                        currentPrice = "19 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie5),
                        name = "Diet Cookie",
                        currentPrice = "24 \$"
                    ),
                    CookiesData(
                        image = painterResource(id = R.drawable.cookie6),
                        name = "LowFat",
                        currentPrice = "21 \$"
                    ),
                )

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
                    ),
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
                    ),
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(cookiesList, cookieOffersList)


                }
            }
        }
    }
}
