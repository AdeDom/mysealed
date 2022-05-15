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
    fun test() {
        val a = 5

        val result = viewModel.sum3(a)

        assertThat(result).isEqualTo(8)
    }
}