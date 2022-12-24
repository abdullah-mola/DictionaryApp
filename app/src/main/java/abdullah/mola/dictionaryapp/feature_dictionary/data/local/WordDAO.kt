package abdullah.mola.dictionaryapp.feature_dictionary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import abdullah.mola.dictionaryapp.feature_dictionary.data.local.entity.WordInfoEntity

@Dao
interface WordDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos: List<WordInfoEntity>)

    @Query("DELETE FROM wordinfoentity WHERE word IN (:words)")
    suspend fun deleteWordInfos(words: List<String>)


    // Pipe || is for String concatenation '%' is a string placeholder
    @Query("SELECT * FROM wordinfoentity WHERE word LIKE '%' || :word || '%'")
    suspend fun getWordInfos(word: String): List<WordInfoEntity>



    @Query("SELECT word, meanings FROM wordinfoentity GROUP BY word ORDER BY id DESC LIMIT 20")
    suspend fun getLastTenWords(): List<WordInfoEntity>

    @Query("SELECT * FROM wordinfoentity ORDER BY id DESC LIMIT 1")
    suspend fun getTheLastSearchWord(): WordInfoEntity?
}