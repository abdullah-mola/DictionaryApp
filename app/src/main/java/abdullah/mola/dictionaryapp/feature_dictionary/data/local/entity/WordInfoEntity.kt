package abdullah.mola.dictionaryapp.feature_dictionary.data.local.entity

import abdullah.mola.dictionaryapp.feature_dictionary.domain.model.Meaning
import abdullah.mola.dictionaryapp.feature_dictionary.domain.model.WordInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wordinfoentity")
data class WordInfoEntity(
    val meanings: List<Meaning>,
    val word: String,
    @PrimaryKey
    val id: Int? = null)


//helper method to convert entity to the model class
fun WordInfoEntity.toWordInfo(): WordInfo {

    return WordInfo(
        word = word,
        meanings = meanings
        )
}










/*/* val origin: String,
    val phonetic: String,*/
) {

    //helper method to convert entity to the model class
    fun toWordInfo(): WordInfo {

        return WordInfo(
            meanings = meanings,
            word = word

        /*origin = origin,
            phonetic = phonetic,*/
        )
    }
}*/
