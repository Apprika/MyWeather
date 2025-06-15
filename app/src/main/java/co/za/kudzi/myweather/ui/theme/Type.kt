package co.za.kudzi.myweather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import co.za.kudzi.myweather.R

val baseline = Typography()

val PoppinsFamily = FontFamily(
    Font(R.font.poppins, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
)

val AppTypography = Typography(
    titleLarge = baseline.titleLarge.copy(
        fontSize = 36.sp,
        color = Color.Black,
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.Bold,
    ),
    titleMedium = baseline.titleMedium.copy(
        fontSize = 18.sp,
        color = Color.Black,
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.SemiBold,
    ),
    displayLarge = baseline.displayLarge.copy(fontFamily = PoppinsFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = PoppinsFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = PoppinsFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = PoppinsFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = PoppinsFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = PoppinsFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = PoppinsFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = PoppinsFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = PoppinsFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = PoppinsFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = PoppinsFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = PoppinsFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = PoppinsFamily),
)