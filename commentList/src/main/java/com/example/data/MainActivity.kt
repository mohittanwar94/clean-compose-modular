package com.example.data

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cleanwithcompose.R
import com.example.cleanwithcompose.ui.theme.CleanWithComposeTheme
import com.example.coreandroid.theme.Typography
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanWithComposeTheme {
                val viewModelComment = hiltViewModel<CommentViewModel>()
                val uiState = viewModelComment.commentUIState.collectAsState()
                CommentsScreen(uiState)
            }
        }
    }
}


data class RunRecord(
    @DrawableRes val icon: Int,
    val title: String,
    val record: String
)

val DrawableId =
    SemanticsPropertyKey<Int>("DrawableResId") // <- Create a new Semantics property named DrawableResId which should hold an Int value
var SemanticsPropertyReceiver.drawableId by DrawableId // <- Create a delegate to add the new property on the semantics Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RunDetailsScreen(
    records: List<RunRecord>,
    modifier: Modifier = Modifier,
    onClick: (Actions) -> Unit,
    id: String?
) {
    println("=======================$id")
    Column(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "",
            modifier = Modifier
                .size(30.dp)
                .clickable(onClick = {
                    onClick.invoke(Actions.Home)
                }),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(0.33f), horizontalAlignment = Alignment.Start) {
                Text(text = "10.01", style = Typography.titleLarge)
                Text(text = "Distance (km)", style = Typography.labelSmall)
            }
            Column(
                modifier = Modifier.weight(0.33f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "01:17:15", style = Typography.titleLarge)
                Text(text = "Duration", style = Typography.labelSmall)
            }
            Column(modifier = Modifier.weight(0.33f), horizontalAlignment = Alignment.End) {
                Text(text = "996", style = Typography.titleLarge)
                Text(text = "Calories", style = Typography.labelSmall)
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Divider()
        Spacer(modifier = Modifier.height(4.dp))
        LazyColumn(
            modifier = modifier
                .padding(16.dp)
                .testTag("records"), // <-Add the test tag on the Modifier
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(records) { index, record ->
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        androidx.compose.material3.Icon(
                            painter = painterResource(id = record.icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(32.dp)
                                .testTag("iconTest")
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = record.title,
                            modifier = Modifier
                                .weight(.8f)
                                .testTag("recordTitle"),
                            style = Typography.titleMedium
                        )
                        Text(
                            text = record.record,
                            modifier = Modifier.testTag("recordValue"), // <- Add a test tag for the record value
                            style = Typography.titleMedium
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                }
            }
        }
    }
}

enum class Actions {
    Home, RUN, BEERS
}

