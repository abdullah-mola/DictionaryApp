package abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SynonymTag(synonym: String, onClickTag: (String) -> Unit) {


    Surface(
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
                .border(
                    width = 1.5.dp,
                    color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable { onClickTag(synonym) }
    ) {

        Row() {
            Text(
                text = synonym,
                style = MaterialTheme.typography.overline,
                textAlign = TextAlign.Center,

                modifier = Modifier.padding(8.dp)
            )
        }
    }

}