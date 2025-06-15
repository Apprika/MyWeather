package co.za.kudzi.myweather.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.za.kudzi.myweather.model.ForecastDisplay

@Composable
fun WeatherLoaded(forecast: ForecastDisplay) {

    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.systemBars))
        Text(
            modifier = Modifier.padding(20.dp),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            text = "${forecast.city} 5 day forecast"
        )
        HorizontalDivider(thickness = 1.dp, color = Color.DarkGray)
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(forecast.foreCasts, key = { it -> it.dt }) {
                WeatherCard(
                    it.dayOfTheWeek,
                    it.degrees,
                    context.resources.getIdentifier(
                        it.iconDrawable,
                        "drawable",
                        context.packageName
                    ),
                    it.background
                )
            }
        }
    }
}