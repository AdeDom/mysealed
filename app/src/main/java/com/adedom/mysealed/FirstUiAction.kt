package com.adedom.mysealed

sealed interface FirstUiAction {
    object ButtonA : FirstUiAction
    data class ButtonB(
        val now: Long,
    ) : FirstUiAction
}