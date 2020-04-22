package com.example.napoleonapplication
import org.junit.Test
import java.io.File


class ExampleUnitTest4 {
    @Test
    fun example(){

        class Product(
            private val price: Double,
            private val salePercent: Int)
        {
            /**
             * @return price with applied discount determined by [salePercent]
             *
             * If [salePercent] is more than 100 than product will
             * If [salePercent] less than 0 product price will be increased
             */
            fun getDiscount() = price * (1 - salePercent/100.0)
        }

        val iphonecase = Product(300.0,20)
        val samsungcase = Product(1000.0,5)

        val priceFormatter: PriceFormatter = CleanKotlinPriceFormatter()

        val myPriseIPhone = iphonecase.getDiscount()
        val myPriseSamsung = samsungcase.getDiscount()
        val formattedIphonePrice = priceFormatter.format(myPriseIPhone)
        println(formattedIphonePrice)
        print(myPriseSamsung)
    }
}

interface PriceFormatter{
    /**
     * Outputs price in <PRICE>руб format.
     * If price have not fractional part than it will be printed as integer
     */
    fun format(price: Double): String
}

class CleanKotlinPriceFormatter : PriceFormatter{
    override fun format(price: Double): String {
        TODO("return")
    }

}