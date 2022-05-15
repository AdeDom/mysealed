package com.adedom.mysealed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {

    private val _uiAction = MutableSharedFlow<FirstUiAction>()
    private val uiAction: SharedFlow<FirstUiAction> = _uiAction.asSharedFlow()

    private val _uiState = MutableStateFlow<FirstUiState>(FirstUiState.Initial)
    val uiState: StateFlow<FirstUiState> = _uiState.asStateFlow()

    init {
        uiAction
            .onEach { uiAction ->
                when (uiAction) {
                    FirstUiAction.ButtonA -> {
                    }
                    is FirstUiAction.ButtonB -> {
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    fun setButtonAAction() {
        viewModelScope.launch {
            val action = FirstUiAction.ButtonA
            _uiAction.emit(action)
        }
    }

    fun setButtonBAction(now: Long) {
        viewModelScope.launch {
            val action = FirstUiAction.ButtonB(now)
            _uiAction.emit(action)
        }
    }
}