package abdullah.mola.dictionaryapp.feature_dictionary.data.local.util

import java.lang.reflect.Type

interface JsonParser {


    /*contains 2 fxns to get an object from a JSON String
    * and to parse an object to JSON String*/

    //takes the actual JSON String and the type to convert into and return an object of our type
    fun <T> fromJson(json: String, type: Type): T?

    //takes the object to be converted, type of that object
    fun <T> toJson(obj: T, type: Type): String?
}