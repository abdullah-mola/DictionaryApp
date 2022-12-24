package abdullah.mola.dictionaryapp.feature_dictionary.presentation.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(

    primary = Teal300,
    primaryVariant = Color.White,
    onPrimary =Color.White,
    secondary = Black1,
    secondaryVariant = Color.White,
    onSecondary = Color.White,
    error = RedErrorLight,
    onError = RedErrorDark,
    background = Color.Black,
    onBackground = Color.White,
    surface = Black1,
    onSurface =Color.White
)

private val LightColorPalette = lightColors(

    primary = Teal200,
    primaryVariant = Teal300,
    onPrimary = Black2,
    secondary = Green300,
    secondaryVariant = Green400,
    onSecondary = Color.Black,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Grey1,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface =Black2,

    )

@Composable
fun DictionaryTheme(darkTheme: Boolean/* = isSystemInDarkTheme()*/, content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}