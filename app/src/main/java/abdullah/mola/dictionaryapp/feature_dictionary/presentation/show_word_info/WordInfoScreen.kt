package abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import abdullah.mola.dictionaryapp.feature_dictionary.presentation.WordInfoItem
import abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info.components.CustomSearchRow
import abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info.components.ShowShimmerCard
import abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info.components.WordChipsRow
import abdullah.mola.dictionaryapp.feature_dictionary.presentation.utils.UIEvent.OnHideKeyboard
import abdullah.mola.dictionaryapp.feature_dictionary.presentation.utils.UIEvent.OnShowSnackbar

@ExperimentalComposeUiApi
@Composable
fun WordInfoScreen( onThemeToggle : () -> Unit,viewModel: WordInfoViewModel = hiltViewModel()) {

    //States
    val wordInfoState by viewModel.wordInfoState
    val searchQuery = viewModel.searchQuery
    val lastTenWords by viewModel.lastTenWords
    val scaffoldState = rememberScaffoldState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val scrollState = rememberScrollState()


    /*Launched Effect listen to events from the
     event flow that we have inside the ViewModel*/
    LaunchedEffect(key1 = true, block = {


        val uiEvent = viewModel.uiEvent.collect { event ->

            when (event) {

                is OnHideKeyboard -> {
                    keyboardController?.hide()

                }
                is OnShowSnackbar -> {

                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.msg,
                        actionLabel = event.action

                    )

                }


            }

        }
    })

    Scaffold(scaffoldState = scaffoldState, topBar = {

        Surface(
            elevation = 8.dp,
            modifier = Modifier.padding(4.dp),
            color = MaterialTheme.colors.surface
        ) {
            Column {

                CustomSearchRow(
                    value = searchQuery,

                    onValueChange = {
                        //takes a string which is passed to event
                        viewModel.onWordInfoEvent(WordInfoEvent.OnSearchTextChange(it))
                    },

                    onClearIconClick = {

                        viewModel.onWordInfoEvent(WordInfoEvent.OnClearSearchText)

                    },

                    onThemeToggle =  onThemeToggle
                )

                Spacer(modifier = Modifier.height(8.dp))
                WordChipsRow(words = lastTenWords, scrollState = scrollState, onClickChip = {

                    //chip click takes a String
                    viewModel.onWordInfoEvent(WordInfoEvent.OnChipClick(it))
                }, coroutineScope = rememberCoroutineScope()
                )



            }

        }

    }) {


        Box (modifier = Modifier.padding(4.dp)){


            Surface(
                elevation = 8.dp,
                color = MaterialTheme.colors.surface
            ) {


                Column(
                    modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                ) {


                    Spacer(modifier = Modifier.height(0.dp))

                    LazyColumn() {

                        if (wordInfoState.wordInfoItems.isEmpty()){
                            item {

                                Column(modifier = Modifier.fillMaxSize(),

                                horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(text = "Type a word to search", style = MaterialTheme.typography.h5)
                                }

                            }

                        } else {

                            items(wordInfoState.wordInfoItems.size) {

                                    i ->

                                val wordInfo = wordInfoState.wordInfoItems[i]

                                //add a spacer for every item apart from the first item
                                if (i > 0) {

                                    Spacer(modifier = Modifier.height(8.dp))
                                }

                                WordInfoItem(
                                    wordInfo = wordInfo,
                                    onClickTag = {
                                        viewModel.onWordInfoEvent(WordInfoEvent.OnTagClick(it))
                                    }
                                )

                                // add a divider for every item apart from the last item
                                if (i < wordInfoState.wordInfoItems.size -1){

                                    Divider()
                                }
                            }
                        }



                    }
                }

            }

            if(wordInfoState.isLoading){
               // CircularProgressIndicator()

                ShowShimmerCard()
            }
        }

    }


}