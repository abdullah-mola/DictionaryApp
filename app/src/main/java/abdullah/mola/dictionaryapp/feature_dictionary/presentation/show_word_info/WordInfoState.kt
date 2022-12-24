package abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info

import abdullah.mola.dictionaryapp.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
