package abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ThemeTogIconButton(onThemeToggle: () -> Unit, modifier: Modifier = Modifier) {
    ConstraintLayout {

        //create id
        val icon = createRef()
        IconButton(onClick = { onThemeToggle() }, modifier.constrainAs(icon){

            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            top.linkTo(parent.bottom)


        }) {

            Icon(

                imageVector = Icons.Default.Settings,
                /*painter = painterResource(id = R.drawable.tog_theme),*/
                contentDescription = null
            )

        }

    }




}
