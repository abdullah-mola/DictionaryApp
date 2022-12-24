package abdullah.mola.dictionaryapp.feature_dictionary.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import abdullah.mola.dictionaryapp.feature_dictionary.domain.model.WordInfo
import abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info.components.SynonymTag


@Composable
fun WordInfoItem(wordInfo: WordInfo, modifier: Modifier = Modifier, onClickTag:(String)->Unit) {


    Column(modifier = modifier) {

        //title - Word
        Text(
            text = wordInfo.word,
            style = MaterialTheme.typography.h4,
            /*fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary*/
        )

        Spacer(modifier = Modifier.height(8.dp))


        //loop over the meanings

        wordInfo.meanings.forEach { meaning ->


            //part of speech e.g. noun, adjective, verb etc

            Text(text = meaning.partOfSpeech, style = MaterialTheme.typography.h6)

            //loop over the meaning of the word

            meaning.definitions.forEachIndexed { i, definition ->

                Text(
                    text = "${i + 1}. ${definition.definition}",
                    style = MaterialTheme.typography.body1
                )


                Spacer(modifier = Modifier.height(8.dp))

                //loop over examples

                definition.example?.let {

                        example ->

                    Text(text = "Example: $example", style = MaterialTheme.typography.body2)

                }
                Spacer(modifier = Modifier.height(8.dp))

                if (definition.synonyms.isNotEmpty()) {

                    Text(text = "Synonyms", style = MaterialTheme.typography.caption)

                }
                Spacer(modifier = Modifier.height(8.dp))
                FlowRow(
                    mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {


                    definition.synonyms.forEach { synonym ->
                        // Text(text = "Synonyms", style = MaterialTheme.typography.h6)
                        if (synonym.isEmpty()) {
                            Text(text = "No Synonyms Found", style = MaterialTheme.typography.body1)

                        } else {

                            SynonymTag(synonym = synonym, onClickTag = onClickTag)
                            //Text(text = "Syn: $it")

                        }


                    }


                }

                Spacer(modifier = Modifier.height(8.dp))

            }
            Spacer(modifier = Modifier.height(8.dp))


        }
    }


}