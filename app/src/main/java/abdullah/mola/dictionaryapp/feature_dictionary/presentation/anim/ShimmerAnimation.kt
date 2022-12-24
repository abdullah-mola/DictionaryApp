package abdullah.mola.dictionaryapp.feature_dictionary.presentation.anim

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import abdullah.mola.dictionaryapp.feature_dictionary.presentation.ui.theme.ShimmerColorShades

@Composable
fun ShimmerAnimation(Content: @Composable (Brush) -> Unit) {

    /*
        Create InfiniteTransition
        which holds child animation like [Transition]
        animations start running as soon as they enter
        the composition and do not stop unless they are removed
       */


    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1300, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    /*
     Create a gradient using the list of colors
     Use Linear Gradient for animating in any direction according to requirement
     start=specifies the position to start with in cartesian like system Offset(10f,10f) means x(10,0) , y(0,10)
     end = Animate the end position to give the shimmer effect using the transition created above
   */

    val brush = Brush.verticalGradient(
        colors = ShimmerColorShades,

        startY = -40f, endY = translateAnim
    )

//Linear gradient
    /*  start = Offset(-40f, -40f),
        end = Offset(translateAnim, translateAnim)*/


    Surface(modifier = Modifier.fillMaxHeight()){
        Content(brush)
    }
    //ShimmerRecipeCardItem(brush = brush)

}