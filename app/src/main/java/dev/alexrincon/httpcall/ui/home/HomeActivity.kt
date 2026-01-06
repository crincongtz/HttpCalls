package dev.alexrincon.httpcall.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.content.IntentCompat
import dev.alexrincon.httpcall.ui.home.screen.HomeActivityActions
import dev.alexrincon.httpcall.ui.home.screen.HomeActivityScreen
import dev.alexrincon.httpcall.ui.home.screen.HomeActivityState
import dev.alexrincon.httpcall.ui.main.MainActivity.Companion.INTENT_KEY_DATA
import dev.alexrincon.httpcall.ui.model.UserData
import dev.alexrincon.httpcall.ui.theme.HttpCallTheme

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userData = IntentCompat.getParcelableExtra(intent, INTENT_KEY_DATA, UserData::class.java)

        setContent {
            HttpCallTheme {
                HomeActivityScreen(
                    state = HomeActivityState(
                        userData = userData
                    ),
                    actions = HomeActivityActions(
                        onBackNavigationPressed = ::onBackNavigation
                    )
                )
            }
        }
    }

    fun onBackNavigation() {
        onBackPressedDispatcher.onBackPressed()
    }
}
