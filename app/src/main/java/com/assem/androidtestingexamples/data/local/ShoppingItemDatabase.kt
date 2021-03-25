package com.assem.androidtestingexamples.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.assem.androidtestingexamples.data.local.ShoppingDao
import com.assem.androidtestingexamples.data.local.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingItemDatabase : RoomDatabase() {

    abstract fun shoppingDao(): ShoppingDao
}