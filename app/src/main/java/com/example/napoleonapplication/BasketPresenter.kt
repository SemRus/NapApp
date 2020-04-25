package com.example.napoleonapplication

import com.example.napoleonapplication.ui.BasketView
import moxy.MvpPresenter

class BasketPresenter: MvpPresenter<BasketView>() {
    private val list = mutableListOf(
        Product("Apple iPhone 6S", 19999.00, 20),
        Product("Honor 20S", 19999.00, 10),
        Product("Sony Xperia 10", 19999.00, 5),
        Product("Samsung Galaxy A71", 29999.00, 15),
        Product("Huawei P30", 31999.00, 15),
        Product("Apple iPhone 7", 36999.00, 3),
        Product("Apple iPhone 8", 36999.00, 30),
        Product("Samsung Galaxy S10", 59999.00, 2),
        Product("Samsung Galaxy S20", 69999.00, 15),
        Product("Huawei Y5 Lite", 5499.00, 15),
        Product("Samsung Galaxy S8", 24999.00, 15)
    )

    fun setData(){
        viewState.setCategories(list)
    }

    fun removeItem(category: Product){
        val position = list.indexOf(category)
        list.remove(category)
        viewState.removeItem(position)
    }

}