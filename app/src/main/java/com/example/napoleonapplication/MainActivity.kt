package com.example.napoleonapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.napoleonapplication.HomeWork6.BasketPresenter
import com.example.napoleonapplication.HomeWork6.Product2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductView {

    private val presenter = BasketPresenter(this)

    private val productFinalPrice = Product2(title = "Iphone Case", price = 150.0, salePercent = 30)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.showBasket()

        product.text = "Товары: " + productFinalPrice.getTitle()
        finalPrice.text = productFinalPrice.calcDiscountPrice().toString()
        price.text = productFinalPrice.getPrice()
        salePersent.text = productFinalPrice.getSalePersent()+" %"



        checkoutButton.setOnClickListener{
            Toast.makeText(this, checkoutName.text, Toast.LENGTH_LONG).show()
        }
    }

    override fun printBasket(printable: String) {
        println(printable)
    }


}
