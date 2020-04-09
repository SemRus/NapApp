package com.example.napoleonapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.napoleonapplication.HomeWork6.BasketPresenter

class MainActivity : AppCompatActivity(), ProductView {

    private val presenter = BasketPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.showBasket()

    }

    override fun printBasket(printable: String) {
        println(printable)
    }

}
