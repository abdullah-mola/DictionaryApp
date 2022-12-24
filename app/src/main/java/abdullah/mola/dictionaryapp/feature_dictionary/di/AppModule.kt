package abdullah.mola.dictionaryapp.feature_dictionary.di

import abdullah.mola.dictionaryapp.Dictionary
import android.content.Context
import androidx.room.Room

import abdullah.mola.dictionaryapp.feature_dictionary.data.local.Converters
import abdullah.mola.dictionaryapp.feature_dictionary.data.local.WordInfoDatabase
import abdullah.mola.dictionaryapp.feature_dictionary.data.local.util.MoshiParser
import abdullah.mola.dictionaryapp.feature_dictionary.data.remote.DictionaryAPI
import abdullah.mola.dictionaryapp.feature_dictionary.data.repository.WordInfoRepositoryImpl
import abdullah.mola.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import abdullah.mola.dictionaryapp.feature_dictionary.domain.use_case.GetTheLastSearchWordUseCase
import abdullah.mola.dictionaryapp.feature_dictionary.domain.use_case.GetWordInfo
import com.plcoding.dictionaryapp.feature_dictionary.domain.use_case.GetLastTenWords
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)


object AppModule {


    //USE CASE 1
    @Provides
    @Singleton
    fun providesUseCase(repository: WordInfoRepository): GetWordInfo {

        return GetWordInfo(repo = repository)
    }


    //USE CASE 2
    @Provides
    @Singleton

    fun provideLastTenWordsUseCase (repository: WordInfoRepository):GetLastTenWords{

        return GetLastTenWords(repository = repository)
    }

    //USE CASE 3
    @Provides
    @Singleton

    fun provideLastSearchWordUseCase(repository: WordInfoRepository):GetTheLastSearchWordUseCase{


        return GetTheLastSearchWordUseCase(repository = repository)
    }

    //REPOSITORY

    @Provides
    @Singleton

    fun providesRepository(db: WordInfoDatabase, api: DictionaryAPI): WordInfoRepository {


        return WordInfoRepositoryImpl(db.wordDAO, api)
    }

    //API

    @Provides
    @Singleton

    fun providesAPI(): DictionaryAPI {

        //initialize moshi
        val moshi: Moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

//Retrofit is not on our project - so we need a builder to create its instance
        return Retrofit.Builder()
                .baseUrl(DictionaryAPI.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(DictionaryAPI::class.java)
    }


    //DATABASE

    @Provides
    @Singleton

    fun providesDatabase(@ApplicationContext context: Context): WordInfoDatabase {

        return Room.databaseBuilder(context, WordInfoDatabase::class.java, "word_db")
                .addTypeConverter(Converters(MoshiParser()))
                .build()
    }

    //APPLICATION
@Provides
@Singleton

fun provideApplication(@ApplicationContext app:Context): Dictionary {


    return app as Dictionary
}

}


