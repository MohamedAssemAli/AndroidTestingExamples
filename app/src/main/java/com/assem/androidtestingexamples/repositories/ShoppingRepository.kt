package com.assem.androidtestingexamples.repositories

import androidx.lifecycle.LiveData
import com.assem.androidtestingexamples.data.local.ShoppingItem
import com.assem.androidtestingexamples.data.remote.responses.ImageResponse
import com.assem.androidtestingexamples.other.Resource

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}