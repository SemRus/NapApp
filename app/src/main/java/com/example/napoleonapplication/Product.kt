package com.example.napoleonapplication

class Product (
    val title: String,
    val price: Double,
    val salePercent: Int
    ) {
        fun calcDiscountPrice():Double{
            return price * (1 - (salePercent/100.0))
        }
}