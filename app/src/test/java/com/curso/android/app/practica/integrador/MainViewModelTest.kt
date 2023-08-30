@file:OptIn(ExperimentalCoroutinesApi::class)

package com.curso.android.app.practica.integrador

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.integrador.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {
    private lateinit var viewModel:MainViewModel

    @get:Rule
    val instantTaskRule= InstantTaskExecutorRule()

    private val dispatcher = StandardTestDispatcher()


    @OptIn(ExperimentalCoroutinesApi::class)

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel= MainViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_checkInitValue()=runTest{
        val value = viewModel.resultaModel.value?.resulta
        assertEquals("",value)
    }

    @Test
    fun mainViewModel_checkScreenValue()=runTest{
        launch {
            viewModel.checkIgual("POLO","MAMBO")
        }
        advanceUntilIdle()

        val value= viewModel.resultaModel.value?.resulta
        assertEquals("NO Son iguales",value)
    }


}