package com.example.napoleonapplication.HomeWork6

class Basket(
    private val products: List<Product2>
){
    fun fullPrice(): Double{
        var result: Double = 0.0

        products.forEach {
            result += it.calcDiscountPrice()
        }

        return result
    }

    fun getProducts(): List<Product2>{
        return products
    }

}