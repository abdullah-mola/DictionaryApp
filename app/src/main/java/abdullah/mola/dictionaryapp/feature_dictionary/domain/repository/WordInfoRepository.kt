package abdullah.mola.dictionaryapp.feature_dictionary.domain.repository

import abdullah.mola.dictionaryapp.core.util.Resource
import abdullah.mola.dictionaryapp.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {


    /*We use a flow to emit multiple values over a perion of time
    * we fist  emit the loading status
    * then we get the actual WordInfo from cache
    * we can then make the request when we get the response we can emit
    * another list of WordInfo gotten from the API*/

    //this is not a suspend fxn because we are using a Flow
    fun getWordInfo(word:String): Flow<Resource<List<WordInfo>>>


    fun getLastTenWords():Flow<Resource<List<WordInfo>>>

    suspend fun getTheLastSearchWord():WordInfo?
}