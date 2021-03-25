package com.assem.androidtestingexamples.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.assem.androidtestingexamples.adapters.ImageAdapter
import com.assem.androidtestingexamples.adapters.ShoppingItemAdapter
import com.assem.androidtestingexamples.ui.AddShoppingItemFragment
import com.assem.androidtestingexamples.ui.ImagePickFragment
import com.assem.androidtestingexamples.ui.ShoppingFragment
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class ShoppingFragmentFactory @Inject constructor(
    private val imageAdapter: ImageAdapter,
    private val glide: RequestManager,
    private val shoppingItemAdapter: ShoppingItemAdapter
): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
            ImagePickFragment::class.java.name -> ImagePickFragment(imageAdapter)
            AddShoppingItemFragment::class.java.name -> AddShoppingItemFragment(glide)
            ShoppingFragment::class.java.name -> ShoppingFragment(shoppingItemAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}