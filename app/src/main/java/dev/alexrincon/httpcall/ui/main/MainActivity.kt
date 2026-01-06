package dev.alexrincon.httpcall.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import dev.alexrincon.httpcall.ui.home.HomeActivity
import dev.alexrincon.httpcall.ui.main.screen.MainActivityActions
import dev.alexrincon.httpcall.ui.main.screen.MainScreen
import dev.alexrincon.httpcall.ui.theme.HttpCallTheme

class MainActivity : ComponentActivity() {
    
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        setContent {
            HttpCallTheme {
                val state by viewModel.mainActivityState.collectAsState()
                MainScreen(
                    state = state,
                    actions = MainActivityActions(
                        onGetRequestButtonClicked = ::getUserData
                    )
                )
            }
        }

        setObservers()
    }

    fun getUserData() {
        viewModel.getDataFromService()
    }

    private fun setObservers() {
        viewModel.userData.observe(this) {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(INTENT_KEY_DATA, it)
            startActivity(intent)
        }
    }

    companion object {
        const val INTENT_KEY_DATA = "user_data"
    }
}
