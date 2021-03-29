package com.assem.androidtestingexamples.di

import android.content.Context
import androidx.room.Room
import com.assem.androidtestingexamples.data.local.ShoppingItemDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

/**
 * Created by mohamedassem on 29-Mar-2021.
 * mohamed.assem.ali@gmail.com
 * https://github.com/MohamedAssemAli
 * https://gitlab.com/mohamed.assem.ali
 */

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Named("test_db")
    fun provideInMemoryDB(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context, ShoppingItemDatabase::class.java)
            .allowMainThreadQueries()
            .build()

}