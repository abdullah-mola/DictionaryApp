package abdullah.mola.dictionaryapp.feature_dictionary.presentation.utils

sealed class UIEvent {


    data class OnShowSnackbar(val msg: String, val action: String) : UIEvent()
    object OnHideKeyboard : UIEvent()

}