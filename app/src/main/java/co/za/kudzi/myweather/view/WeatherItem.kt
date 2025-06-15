package co.za.kudzi.myweather.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import co.za.kudzi.myweather.R

@Composable
fun WeatherCard(
    dayOfTheWeek: String,
    degrees: String,
    iconDrawable: Int,
    background: Int
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        ),
        modifier = Modifier
            .height(135.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = background),
                    contentScale = ContentScale.FillWidth
                )
        ) {
            val (day, temperature, icon) = createRefs()
            val margin = 16.dp

            Text(
                text = dayOfTheWeek,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .constrainAs(day) {
                        top.linkTo(parent.top, margin = margin)
                        start.linkTo(parent.start, margin = margin)
                    }
            )

            Image(
                painter = painterResource(id = iconDrawable),
                contentDescription = "Weather Icon",
                modifier = Modifier
                    .size(65.dp)
                    .clip(CircleShape)
                    .constrainAs(icon) {
                        bottom.linkTo(parent.bottom, margin = margin)
                        start.linkTo(parent.start, margin = margin)
                    }
            )

            Text(
                text = degrees,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .constrainAs(temperature) {
                        bottom.linkTo(parent.bottom, margin = margin)
                        end.linkTo(parent.end, margin = margin)
                    }
            )
        }
    }
}

@Preview
@Composable
fun WeatherCardPreview(
    day: String = "Monday",
    degrees: String = "20°",
    background: Int = R.drawable.group_sunny,
    image: Int = R.drawable.property_1_03_sunrise_light
) {
    WeatherCard(
        dayOfTheWeek = day,
        degrees = degrees,
        iconDrawable = image,
        background = background
    )
}