package com.example.napoleonapplication

import com.example.napoleonapplication.ui.CatalogView
import moxy.MvpPresenter

class CatalogPresenter : MvpPresenter<CatalogView>() {

    private val list = mutableListOf(
        Product("Iphone case", 100.00, 30)

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