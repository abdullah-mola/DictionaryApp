package abdullah.mola.dictionaryapp.feature_dictionary.data.remote.dto

import abdullah.mola.dictionaryapp.feature_dictionary.data.local.entity.WordInfoEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WordInfoDTO(
    val meanings: List<MeaningDTO>,
    val word: String

    //val origin: String? = null,
    //val phonetic: String? = null,
    //val phonetics: List<PhoneticDTO>,

)

fun WordInfoDTO.toWordInfoEntity(): WordInfoEntity {

    return WordInfoEntity( word = word,meanings = meanings.map { it.toMeaning() })

}














/*Null Check
*
*
*  if (phonetic === null || origin == null) {

        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            origin = "origin: _ _",
            phonetic = "phonetic: _ _",
            word = word
        )

    } else {

        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )

    }
* */