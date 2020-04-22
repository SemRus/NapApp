package com.example.napoleonapplication

import org.junit.Test
import kotlin.math.floor

class ExampleUnitTest1 {


    @Test
    fun example1(){
        val printBasket = Basket(listOf(
            Product(title = "Iphone Case", price = 150.0, salePercent = 30),
            Product(title = "Samsung Case", price = 150.0, salePercent = 5)
        ))

        val basketPrinter: PricePrinter<Basket> = PriceFormat()

        basketPrinter.format(printBasket)
    }

}



class Basket(
    private val products: List<Product>
){
    fun fullPrice(): Double{
        var result: Double = 0.0

        products.forEach {
            result += it.calcDiscountPrice()
        }

        return result
    }

    fun getProducts(): List<Product>{
        return products
    }
}

class Product(
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

interface PricePrinter<T>{
    fun format (printable: Basket)
}

class PriceFormat: PricePrinter<Basket>{
    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    override fun format(printable: Basket) {

        fun formatPrice(price: Double): String{
            return if (floor(price) ==price){
                String.format("%.0f"+"р", price)
            } else{
                String.format("%.2f"+"р", price)
            }
        }

        printable.getProducts().forEach {
            val price = it.calcDiscountPrice()
            println("${it.getTitle()}: ${formatPrice(price)}")
        }

        println("Цена на все товары: ${formatPrice(printable.fullPrice())}")
    }
}