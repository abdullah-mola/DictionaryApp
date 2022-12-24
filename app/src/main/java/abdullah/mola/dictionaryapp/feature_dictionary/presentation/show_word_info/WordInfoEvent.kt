package abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info

sealed class WordInfoEvent {

    data class OnTagClick(val synonym: String) :WordInfoEvent()
    object OnClearSearchText  :WordInfoEvent()
    data class OnChipClick(val word:String):WordInfoEvent()
    data class OnSearchTextChange(val text:String):WordInfoEvent()
}
