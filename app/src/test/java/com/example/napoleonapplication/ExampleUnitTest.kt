package com.example.napoleonapplication

import org.junit.Test

import org.junit.Assert.*


fun formatPrise(price: Double, size: String, discount: Int) {
    if(discount != 0){
        val discountPrice: Double = price - (price * discount/100)
        val formatted: String
        if (Math.floor(discountPrice)==discountPrice){
            formatted = String.format("%.0f", discountPrice)
            println("Цена товара: $formatted/$size (скидка $discount%)")
        }
        else{
            formatted = String.format("%.2f", discountPrice)
            println("Цена товара: $formatted/$size (скидка $discount%)")
        }
    }
    else{
        val formatted: String
        if (Math.floor(price)==price){
            formatted = String.format("%.0f", price)
            println("Цена товара: $formatted/$size")
        }
        else{
            formatted = String.format("%.2f", price)
            println("Цена товара: $formatted/$size")
        }

    }
}

class ExampleUnitTest2 {

    @Test
    fun addition_fun(){
        formatPrise(price = 10.0,size = "kg",discount = 10)
    }









//    fun Discrimenant(a:Double,b:Double,c:Double){
//        var D = Math.pow(b,2.0) - 4*a*c
//        var x1 = (-b - Math.sqrt(D))/(2*a)
//        var x2 = (-b + Math.sqrt(D))/(2*a)
//        println("x1 = $x1")
//        print("x2 = $x2")
//    }
}
