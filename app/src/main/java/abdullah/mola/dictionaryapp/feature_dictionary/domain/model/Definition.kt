package abdullah.mola.dictionaryapp.feature_dictionary.domain.model

//checked on example:String? matches Phill's src code

data class Definition (   val antonyms: List<String>,
                     val definition: String,
                     val example: String?,
                     val synonyms: List<String>) {


}