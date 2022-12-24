package abdullah.mola.dictionaryapp.feature_dictionary.data.remote

import abdullah.mola.dictionaryapp.feature_dictionary.data.remote.dto.WordInfoDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryAPI {

    @GET(value = "/api/v2/entries/en/{word}")
    suspend fun getWordInfo(@Path(value = "word") word:String):List<WordInfoDTO>

    companion object{

        const val BASE_URL = "https://api.dictionaryapi.dev/"
    }
}