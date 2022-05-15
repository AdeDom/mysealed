package com.adedom.mysealed

sealed interface FirstUiState {
    data class Initial(
        val textA :String = "Initial A",
        val textB :String = "Initial B",
        val textC :String = "Initial C",
    ) : FirstUiState
    data class ButtonAClicked(
        val textAShow: Boolean,
        val textA: String,
        val textB: String = "-",
        val textC: String = "-",
    ) : FirstUiState

    data class ButtonBClicked(
        val textAShow: Boolean,
        val text: String,
        val now: String,
    ) : FirstUiState
}