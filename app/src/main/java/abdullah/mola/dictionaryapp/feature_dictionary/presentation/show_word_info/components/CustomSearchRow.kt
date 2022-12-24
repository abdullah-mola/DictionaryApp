package abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CustomSearchRow(
    value: String,
    onValueChange: (String) -> Unit,
    onClearIconClick: () -> Unit,
    onThemeToggle: () -> Unit
) {


    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        SearchTextField(
            value = value,
            onValueChange = onValueChange,
            onClearIconClick = onClearIconClick
        )


        ThemeTogIconButton(
            onThemeToggle = onThemeToggle,
            modifier = Modifier.align(CenterVertically)
        )

    }


}


@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onClearIconClick: () -> Unit
) {
    TextField(
        value = value.uppercase(),
        onValueChange = onValueChange,

        label = { Text("Search") },
        keyboardOptions = KeyboardOptions(
            autoCorrect = true,
            keyboardType = KeyboardType.Text
        ),

        leadingIcon = {

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },

        trailingIcon = {

            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                Modifier.clickable { onClearIconClick() }
            )
        },


        textStyle = MaterialTheme.typography.h5,
/*
        textStyle = TextStyle(color = MaterialTheme.colors.onSurface),*/
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            leadingIconColor = MaterialTheme.colors.primary,
            trailingIconColor = MaterialTheme.colors.primary
        ),


        singleLine = true,
        modifier = Modifier
                .fillMaxWidth(0.90f)
                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)

    )

    //Spacer(modifier = Modifier.width(2.dp))


}


@Preview(name = "TextPreview")
@Composable
fun MyTextFieldPreview() {


    CustomSearchRow(value = "", onValueChange = {}, {}) {

    }

}
