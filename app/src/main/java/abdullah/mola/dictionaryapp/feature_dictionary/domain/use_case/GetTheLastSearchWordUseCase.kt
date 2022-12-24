package abdullah.mola.dictionaryapp.feature_dictionary.domain.use_case

import abdullah.mola.dictionaryapp.feature_dictionary.domain.model.WordInfo
import abdullah.mola.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository


class GetTheLastSearchWordUseCase(private  val repository: WordInfoRepository) {

    suspend operator fun invoke(): WordInfo? {

        return repository.getTheLastSearchWord()
    }
}