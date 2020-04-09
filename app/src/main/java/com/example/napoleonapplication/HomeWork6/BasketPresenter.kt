package com.example.napoleonapplication.HomeWork6

import com.example.napoleonapplication.ProductView

class BasketPresenter (
    private val view: ProductView
): InnterBasket {
    private val printBasket = Basket(listOf(
        Product2(title = "Iphone Case", price = 150.0, salePercent = 30),
        Product2(title = "Samsung Case", price = 150.0, salePercent = 5)
    ))

    private val cartFormatter: Form<Basket> = BasketForm()

    override fun showBasket() {
        val result = cartFormatter.format(printBasket)

        view.printBasket(result)
    }

}