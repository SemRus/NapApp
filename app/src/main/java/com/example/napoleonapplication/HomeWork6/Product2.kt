package com.example.napoleonapplication.HomeWork6

class Product2 (
    /**
     * Must be positive
     */
    private val title: String,
    private val price: Double,
    private val salePercent: Int = 0
    ) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
        fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)

        fun getTitle(): String{
            return title
        }
}