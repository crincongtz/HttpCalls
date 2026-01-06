package dev.alexrincon.httpcall.ui.home.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alexrincon.httpcall.R
import dev.alexrincon.httpcall.ui.model.UserData
import dev.alexrincon.httpcall.ui.theme.HttpCallTheme

@Preview(showBackground = true)
@Composable
fun HomeActivityScreenPreview() {
    HttpCallTheme {
        HomeActivityScreen(
            state = HomeActivityState(
                UserData(
                    userId = 22,
                    title = "Demo text",
                    completed = false
                )
            ),
            actions = HomeActivityActions(
                onBackNavigationPressed = {}
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeActivityScreen(
    state: HomeActivityState,
    actions: HomeActivityActions,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(stringResource(R.string.home_screen_name))
                },
                navigationIcon = {
                    IconButton(onClick = { actions.onBackNavigationPressed.invoke() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back navigation"
                        )
                    }
                },
            )
        },
        containerColor = Color.White
    ) { innerPadding ->
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(20.dp)
        ) {
            Row (
                modifier = Modifier.padding(16.dp),
            ) {
                Text(
                    text = stringResource(R.string.user_data_label_title),
                )
                Text(
                    text = state.userData?.title.toString(),
                    modifier = Modifier.padding(start = 8.dp),
                    fontSize = 20.sp
                )
            }
            Row(
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
            ) {
                Text(
                    text = stringResource(R.string.user_data_label_completed),
                )
                Text(
                    text = state.userData?.completed.toString(),
                    modifier = Modifier.padding(start = 8.dp),
                    fontSize = 20.sp
                )
            }
        }
    }
}
