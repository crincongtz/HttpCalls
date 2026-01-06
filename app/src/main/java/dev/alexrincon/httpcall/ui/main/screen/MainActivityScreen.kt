package dev.alexrincon.httpcall.ui.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alexrincon.httpcall.R
import dev.alexrincon.httpcall.ui.theme.HttpCallTheme

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    HttpCallTheme {
        MainScreen(
            state = MainActivityState(),
            actions = MainActivityActions(
                onGetRequestButtonClicked = {}
            )
        )
    }
}

@Composable
fun MainScreen(
    state: MainActivityState,
    actions: MainActivityActions,
    modifier: Modifier = Modifier
) {
    Scaffold(
        containerColor = Color.White,
        modifier = modifier
    ) { innerPadding ->

        Box(modifier) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Button(
                    onClick = actions.onGetRequestButtonClicked,
                ) {
                    Text(
                        text = stringResource(R.string.get_request_label),
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            if (state.showProgress) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.LightGray.copy(alpha = 0.9f))
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(80.dp),
                        strokeWidth = 6.dp
                    )
                }
            }
        }
    }
}
