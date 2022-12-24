package abdullah.mola.dictionaryapp.feature_dictionary.data.remote.dto


import abdullah.mola.dictionaryapp.feature_dictionary.domain.model.Meaning
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeaningDTO(
    val definitions: List<DefinitionDTO>,
    val partOfSpeech: String
){

    fun toMeaning():Meaning{

        return Meaning(definitions = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech)
    }
}