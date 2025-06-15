package co.za.kudzi.myweather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import co.za.kudzi.myweather.R

val poppinsFamily = FontFamily(
    Font(R.font.poppins, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
)

val Typography = Typography(
    titleLarge = TextStyle(
        lineHeight = 28.sp,
        fontSize = 36.sp,
        color = Color.Black,
        letterSpacing = 0.sp,
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Bold,
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        color = Color.Black,
        letterSpacing = 0.15.sp,
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.SemiBold,
    )
)