package com.example.napoleonapplication.HomeWork6

import kotlin.math.floor

class BasketForm : Form<Basket> {


    override fun format(formatted: Basket): String {
        var fullPrice: String = " "

        fun formatPrice(price: Double): String{
            return if (floor(price) ==price){
                String.format("%.0f"+"р", price)
            } else{
                String.format("%.2f"+"р", price)
            }
        }

        formatted.getProducts().forEach {
            val price = it.calcDiscountPrice()
            fullPrice += "${it.getTitle()}: ${formatPrice(price)} \n"
        }

        fullPrice += ("Цена на все товары: ${formatPrice(formatted.fullPrice())}")

        return fullPrice
    }
}