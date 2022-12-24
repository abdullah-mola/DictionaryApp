package abdullah.mola.dictionaryapp.feature_dictionary.presentation.ui.theme


import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import abdullah.mola.dictionaryapp.R


//initialize font family - FontFamily takes a list of fonts

/*private val RobotoCondensed = FontFamily(
    Font(resId = R.font.roboto_condensed_light, weight = FontWeight.W300),
    Font(resId = R.font.roboto_condensed_light_italic, weight = FontWeight.W200),
    Font(resId = R.font.roboto_condensed_regular, weight = FontWeight.W400),
    Font(resId = R.font.roboto_condensed_bold, weight = FontWeight.W500)
)*/




private val Rajdhani = FontFamily(


    Font(resId = R.font.rajdhani_bold, weight = FontWeight.W500),
    Font(resId = R.font.rajdhani_medium, weight = FontWeight.W400),
    Font(resId = R.font.rajdhani_regular, weight = FontWeight.W300),
    Font(resId = R.font.rajdhani_light, weight = FontWeight.W200)


)


/*
private val BitterFontFamily = FontFamily(
    Font(resId = R.font.bitter_extra_bold, FontWeight.ExtraBold),
    Font(resId = R.font.bitter_bold, FontWeight.Bold),
    Font(resId = R.font.bitter_semi_bold, FontWeight.SemiBold),
    Font(resId = R.font.bitter_medium, FontWeight.Medium),
    Font(resId = R.font.bitter_regular, FontWeight.Normal),
*/
/*    Font(resId = R.font.bitter_italic, FontWeight.W300),*//*

    Font(resId = R.font.bitter_light, FontWeight.Light),
    Font(resId = R.font.bitter_italic_light, FontWeight.W200),
    Font(resId = R.font.bitter_thin, FontWeight.Thin),


)
*/

// Set of Material typography styles to start with
val Typography = Typography(

    h4 = TextStyle(
        color = Teal300,
        fontFamily = Rajdhani,
        fontSize = 36.sp,
        fontWeight = FontWeight.W500
    ),
    h5 = TextStyle(
        fontFamily = Rajdhani,
        fontSize = 24.sp,
        fontWeight = FontWeight.W500,
        textAlign = TextAlign.Center,

    ),
    h6 = TextStyle(
        color = Teal200,
        fontFamily = Rajdhani,
        fontSize = 24.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.W400,
        textAlign = TextAlign.Center
    ),


    body1 = TextStyle(
        fontFamily = Rajdhani,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal
    ),

    body2 = TextStyle(

        fontFamily = Rajdhani,
        fontSize = 18.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Medium
    ),

    caption = TextStyle(
        fontFamily = Rajdhani,
        fontSize = 16.sp,
        fontWeight = FontWeight.W400
    ),

    overline = TextStyle(
        fontStyle = FontStyle.Italic,
        fontFamily = Rajdhani,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),


    //Other default text styles to override
    button = TextStyle(
        fontFamily = Rajdhani,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    )



)


private val QuickSandFontFamily = FontFamily(
    Font(R.font.quicksand_light, FontWeight.W300),
    Font(R.font.quicksand_regular, FontWeight.W400),
    Font(R.font.quicksand_medium, FontWeight.W500),
    Font(R.font.quicksand_bold, FontWeight.W600)
)


val QuickSandTypography = Typography(
    h1 = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),

    subtitle1 = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),


    subtitle2 = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),

    body1 = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp,
        color = Color.White
    ),

    caption = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = QuickSandFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
)