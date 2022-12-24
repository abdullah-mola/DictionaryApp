package abdullah.mola.dictionaryapp.feature_dictionary.data.remote.dto


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhoneticDTO(
    val audio: String,
    val text: String
){

    /*fun toPhonetic(): Phonetic {

        return Phonetic(
            audio = audio,
            text = text
        )
    }*/
}