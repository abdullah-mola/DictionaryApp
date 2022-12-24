package abdullah.mola.dictionaryapp.feature_dictionary.presentation.show_word_info.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import abdullah.mola.dictionaryapp.feature_dictionary.presentation.anim.ShimmerAnimation

@Composable
fun ShimmerCardItem(brush: Brush) {


    Column(modifier = Modifier.height(700.dp).padding(8.dp)) {


        Spacer(
            modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                  /*  .height(50.dp)*/
                    .background(brush = brush)
        )

        Spacer(
            modifier = Modifier
                   .fillMaxWidth()
                   /* .height(7000.dp)*/
               .weight(3f)
                    .padding(vertical = 16.dp)
                    .background(brush = brush)
        )
    }
}


@Composable
fun ShowShimmerCard() {
    
    
    LazyColumn(content = {
        
        item { 
            
            ShimmerAnimation {
                brush -> ShimmerCardItem(brush = brush)
            }
        }
    })
    
}