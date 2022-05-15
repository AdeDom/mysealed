package com.adedom.mysealed

sealed interface FirstUiState {
    object Initial : FirstUiState
    data class ButtonAClicked(
        val textAShow: Boolean,
        val text: String,
    ) : FirstUiState

    data class ButtonBClicked(
        val textAShow: Boolean,
        val text: String,
        val now: String,
    ) : FirstUiState
}