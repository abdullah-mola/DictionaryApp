package abdullah.mola.dictionaryapp.feature_dictionary.data.local.util

import abdullah.mola.dictionaryapp.feature_dictionary.domain.model.Meaning
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type

class MoshiParser() : JsonParser {

    //initialize Moshi
    private val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    override fun <T> fromJson(json: String, type: Type): T? {

        //use jsonAdapter<T> for generic adapter
        val jsonAdapter: JsonAdapter<T> = moshi.adapter(type)
        return jsonAdapter.fromJson(json)

    }

    override fun <T> toJson(obj: T, type: Type): String? {

    //use jsonAdapter<T> for generic adapter
        val jsonAdapter: JsonAdapter<T> = moshi.adapter(type)

        return jsonAdapter.toJson(obj)
    }

}


/*
* //JsonParser implementation
class MoshiParser (private val gson: Gson):JsonParser {
    override fun <T> fromJson(json: String, type: Type): T? {

        return gson.fromJson(json,type)
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        return gson.toJson(obj,type)
    }
}
*
* */