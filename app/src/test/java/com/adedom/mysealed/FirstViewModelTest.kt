package com.adedom.mysealed

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class FirstViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: FirstViewModel

    @Before
    fun setUp() {
        viewModel = FirstViewModel()
    }

    @Test
    fun firstUiStateInitial() {
        val result = viewModel.uiState.value as FirstUiState.Initial
        assertThat(result.textA).isEqualTo("Initial A")
        assertThat(result.textB).isEqualTo("Initial B")
        assertThat(result.textC).isEqualTo("Initial C")
    }

    @Test
    fun setButtonAAction_FirstUiStateButtonAClicked() {
        viewModel.setButtonAAction()

        val result = viewModel.uiState.value as FirstUiState.ButtonAClicked
        assertThat(result.textAShow).isTrue()
        assertThat(result.textA).isEqualTo("Hello, A")
        assertThat(result.textB).isEqualTo("-")
        assertThat(result.textC).isEqualTo("-")
    }

    @Test
    fun setButtonBAction_FirstUiStateButtonBClicked() {
        val now = 123456L

        viewModel.setButtonBAction(now)

        val result = viewModel.uiState.value as FirstUiState.ButtonBClicked
        assertThat(result.textAShow).isFalse()
        assertThat(result.text).isEqualTo("Hello, B")
        assertThat(result.now).isEqualTo("123456")
    }
}