package abdullah.mola.dictionaryapp.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import abdullah.mola.dictionaryapp.feature_dictionary.data.local.util.JsonParser
import abdullah.mola.dictionaryapp.feature_dictionary.domain.model.Meaning


/*nnotate the class with @ProvidedTypeConverter because we need
to provide our instance of a TypeConverter.*/
@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {


    // @TypeConverter annotation to mark it as a type converter function
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<List<Meaning>>(){}.type
        ) ?: emptyList()
    }

    // @TypeConverter annotation to mark it as a type converter function
    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<List<Meaning>>(){}.type
        ) ?: "[]"
    }
}