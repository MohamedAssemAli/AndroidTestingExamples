package com.assem.androidtestingexamples.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.assem.androidtestingexamples.MainCoroutineRule
import com.assem.androidtestingexamples.getOrAwaitValueTest
import com.assem.androidtestingexamples.other.Constants
import com.assem.androidtestingexamples.other.Status
import com.assem.androidtestingexamples.repositories.FakeShoppingRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by mohamedassem on 29-Mar-2021.
 * mohamed.assem.ali@gmail.com
 * https://github.com/MohamedAssemAli
 * https://gitlab.com/mohamed.assem.ali
 */

@ExperimentalCoroutinesApi
class ShoppingViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewmodel: ShoppingViewModel

    @Before
    fun setup() {
        viewmodel = ShoppingViewModel(FakeShoppingRepository())
    }

    @Test
    fun `insert item with empty field, returns error`() {
        viewmodel.insertShoppingItem("name", "", "3.0")
        val value = viewmodel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert item with long name, returns error`() {
        val name = buildString {
            for (i in 1..Constants.MAX_NAME_LENGTH + 1)
                append(i)
        }
        viewmodel.insertShoppingItem(name, "5", "3.0")
        val value = viewmodel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }


    @Test
    fun `insert item with long price, returns error`() {
        val price = buildString {
            for (i in 1..Constants.MAX_PRICE_LENGTH + 1)
                append(i)
        }
        viewmodel.insertShoppingItem("name", "5", price)
        val value = viewmodel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert item with too high amount, returns error`() {
        viewmodel.insertShoppingItem("name", "99999999999999999999999999999999999999999999", "3.0")
        val value = viewmodel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert item with valid input, returns error`() {
        viewmodel.insertShoppingItem("name", "1", "5.0")
        val value = viewmodel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.SUCCESS)
    }


    @After
    fun teardown() {

    }
}