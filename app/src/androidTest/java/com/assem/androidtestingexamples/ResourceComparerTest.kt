package com.assem.androidtestingexamples

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by Mohamed Assem Ali on 25 Mar 2021.
 * mohamed.assem.ali@gmail.com
 * https://github.com/MohamedAssemAli
 * Company: Orchtech
 */
class ResourceComparerTest {

    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setup() {
        resourceComparer = ResourceComparer()
    }

    @After
    fun teardown() {
        
    }

    @Test
    fun stringResourceSameAsGivenString_resturnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "AndroidTestingExamples")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentFromGivenString_resturnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "HelloWorld")
        assertThat(result).isFalse()
    }


}