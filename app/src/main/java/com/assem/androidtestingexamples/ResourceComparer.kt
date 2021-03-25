package com.assem.androidtestingexamples

import android.content.Context


/**
 * Created by Mohamed Assem Ali on 25 Mar 2021.
 * mohamed.assem.ali@gmail.com
 * https://github.com/MohamedAssemAli
 * Company: Orchtech
 */
class ResourceComparer {

    fun isEqual(context: Context, resId: Int, string: String): Boolean {
        return context.getString(resId) == string
    }
}