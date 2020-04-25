package com.example.napoleonapplication.ui

import com.example.napoleonapplication.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BasketView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setCategories(list: MutableList<Product>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position: Int)
}