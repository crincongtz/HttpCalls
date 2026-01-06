package dev.alexrincon.httpcall.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.alexrincon.httpcall.data.repository.SimpleDataRepository
import dev.alexrincon.httpcall.ui.main.screen.MainActivityState
import dev.alexrincon.httpcall.ui.model.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {

    private var simpleDataRepository = SimpleDataRepository()

    private val _mainActivityState = MutableStateFlow(MainActivityState())
    val mainActivityState: StateFlow<MainActivityState> get() = _mainActivityState.asStateFlow()

    private var _userData : MutableLiveData<UserData> = MutableLiveData()
    val userData : LiveData<UserData> get() = _userData

    fun getDataFromService() {
        showProgress(true)
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            val response = simpleDataRepository.getSimpleData()
            if (response.isSuccessful) {
                response.body()?.let {
                    val userData = UserData(
                        userId = it.userId,
                        title = it.title,
                        completed = it.completed
                    )
                    showProgress(false)
                    withContext(Dispatchers.Main) {
                        _userData.value = userData
                    }
                }
            }
        }
    }

    private fun showProgress(value: Boolean) {
        _mainActivityState.update {
            it.copy(
                showProgress = value
            )
        }
    }
}
