package com.plcoding.dictionaryapp.feature_dictionary.domain.use_case

import abdullah.mola.dictionaryapp.core.util.Resource
import abdullah.mola.dictionaryapp.feature_dictionary.domain.model.WordInfo
import abdullah.mola.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow

class GetLastTenWords(private val repository: WordInfoRepository) {

    operator fun invoke(): Flow<Resource<List<WordInfo>>> {


        return repository.getLastTenWords()
    }



}