package abdullah.mola.dictionaryapp.feature_dictionary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.compose.ui.ExperimentalComposeUiApi
import abdullah.mola.dictionaryapp.Dictionary

import abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info.WordInfoScreen
import abdullah.mola.dictionaryapp.feature_dictionary.presentation.ui.theme.DictionaryTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    //Main Activity has an empty constructor, field injection is done
    @Inject
    lateinit var app:Dictionary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

         DictionaryTheme(darkTheme = app.isDark) {

             WordInfoScreen(
                 onThemeToggle = { app.toggleTheme() }

             )

         }
        }
    }
}