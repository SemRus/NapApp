package com.example.napoleonapplication

import org.junit.Test

class ExampleUnitTest {

    private val presenter = Presenter()

    @Test
    fun example() {
        presenter.productNamePrint()
        presenter.pricePrint()
    }
}


class Presenter{
    private val iphoneCase = Product2(price = 100.0, salePercent = 30, productName = "Iphone Case")
    private val samsungCase = Product2(price = 150.0, salePercent = 5, productName = "Samsung Case")

    private val pricePrinter: PricePrinter2 = ConsolePricePrinter()
    private val products = listOf(iphoneCase, samsungCase)

    fun pricePrint(){
        products.forEach { product ->
            pricePrinter.print(product.calcDiscountPrice())
        }
    }

    fun productNamePrint(){
        products.forEach { product ->
            pricePrinter.format(product.getProductName())
        }
    }
}

class Product2(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0,
    private val productName: String)
{
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double {
        val sale = price * salePercent/100.0
        return price - sale
    }

    fun getProductName(): String = productName
}

interface PricePrinter2 {

    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)

    fun format(name: String)
}

class ConsolePricePrinter : PricePrinter2 {

    override fun print(price: Double) {
        println(price)
    }

    override fun format(name: String) {
        println(name)
    }

}