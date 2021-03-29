package com.assem.androidtestingexamples

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

/**
 * Created by mohamedassem on 29-Mar-2021.
 * mohamed.assem.ali@gmail.com
 * https://github.com/MohamedAssemAli
 * https://gitlab.com/mohamed.assem.ali
 */

class HiltTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)

    }
}