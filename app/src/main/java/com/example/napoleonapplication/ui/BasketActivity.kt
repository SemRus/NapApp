package com.example.napoleonapplication.ui

import android.content.Intent
import android.os.Bundle
import com.example.napoleonapplication.R
import kotlinx.android.synthetic.main.basket_layout.*

class BasketActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basket_layout)

        catalogCheckoutBtn.setOnClickListener{
            val intent = Intent(this,CheckoutActivity::class.java).apply {
                putExtra(BasketActivity.PRODUCT_ID, 1000)
            }
            startActivity(intent)
        }

        BackBasketBtn.setOnClickListener {
            finish()
        }

    }
    companion object{
        const val PRODUCT_ID = "PRODUCT_ID"
    }
}