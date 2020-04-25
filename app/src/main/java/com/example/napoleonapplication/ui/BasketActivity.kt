package com.example.napoleonapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.napoleonapplication.BasketPresenter
import com.example.napoleonapplication.CatalogPresenter
import com.example.napoleonapplication.Product
import com.example.napoleonapplication.R
import kotlinx.android.synthetic.main.basket_layout.*
import kotlinx.android.synthetic.main.catalog_layout.*

class BasketActivity: BaseActivity(), BasketView {

    private val presenter = BasketPresenter()
    private val adapter = CategoryAdapter {category ->
        presenter.removeItem(category)
    }

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

        BasketRv.layoutManager = LinearLayoutManager(this)
        BasketRv.adapter = adapter
        presenter.setData()
        presenter.attachView(this)

    }
    companion object{
        const val PRODUCT_ID = "PRODUCT_ID"
    }

    override fun setCategories(list: MutableList<Product>) {
        adapter.setData(list)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }

}