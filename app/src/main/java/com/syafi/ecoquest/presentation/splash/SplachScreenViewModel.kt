package com.syafi.ecoquest.presentation.splash

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syafi.ecoquest.data.DataStoreRepository
import com.syafi.ecoquest.util.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    var _startDestination by mutableStateOf(Routes.WELCOME)
        private set

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination = Routes.LOGIN
                } else {
                    _startDestination = Routes.WELCOME
                }
            }
        }
    }

}