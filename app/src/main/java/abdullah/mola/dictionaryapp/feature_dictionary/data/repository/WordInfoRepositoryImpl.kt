package abdullah.mola.dictionaryapp.feature_dictionary.data.repository

import abdullah.mola.dictionaryapp.core.util.Resource
import abdullah.mola.dictionaryapp.feature_dictionary.data.local.WordDAO
import abdullah.mola.dictionaryapp.feature_dictionary.data.local.entity.toWordInfo
import abdullah.mola.dictionaryapp.feature_dictionary.data.remote.DictionaryAPI
import abdullah.mola.dictionaryapp.feature_dictionary.data.remote.dto.toWordInfoEntity
import abdullah.mola.dictionaryapp.feature_dictionary.domain.model.WordInfo
import abdullah.mola.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val dao: WordDAO,
    private val api: DictionaryAPI
) :
    WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {

//EMIT LOADING
        //we first emit loading before we start the request to display progress bar

        emit(Resource.Loading())

        //EMIT FROM DATABASE
        // read the current word from database and convert it to domail level object
        val wordInfos = dao.getWordInfos(word = word)
                .map { it.toWordInfo() }

        //emit the cache in the meantime while awaiting an update from the API

        /*we attach some data to the loading - this will now notify the ViewModel
        * that there is word info to display*/
        emit(Resource.Loading(wordInfos))


//GET INFO FROM API & SAVE INTO THE DB
        try {
            //initiate the API call
            val remoteWordInfos = api.getWordInfo(word)

            //at this point the request is successful and we can delete wordInfo from the db
            dao.deleteWordInfos(remoteWordInfos.map { it.word })

            //then we replace the word infos in the db with info from the API
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })
            //EMIT FROM THE DB WITH UPDATED INFO
            val newWordInfos = dao.getWordInfos(word)
                    .map { it.toWordInfo() }
            emit(Resource.Success(data = newWordInfos))
        }

        //EMIT ERRORS IF ANY
        //if the request did not complete/ invalid response
        catch (e: HttpException) {

            emit(
                Resource.Error(
                    "Ooops something went wrong"
                    //in error case we can potentially get data from the db
//wordInfos is from database

                )
            )


        }
        //servers unreachable, parsing issue, no internet connection
        catch (e: IOException) {

            emit(
                Resource.Error(
                    "Couldn't reach server, check your internet connection",
                    //in error case we can potentially get data from the db

                    data = wordInfos
                )
            )
        }

        //read again from the database after the remote update


    }

    override fun getLastTenWords(): Flow<Resource<List<WordInfo>>> = flow {


        try {
            val lastTenWordsList = dao.getLastTenWords()
                    .map { it.toWordInfo() }
            emit(Resource.Success(data = lastTenWordsList))
        } catch (e: IOException) {


            emit(Resource.Error(message = "${e.message} caused by ${e.cause}"))
        }
    }

    override suspend fun getTheLastSearchWord(): WordInfo? {

        return dao.getTheLastSearchWord()?.toWordInfo()
    }
}