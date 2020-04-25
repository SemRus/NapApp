package com.example.napoleonapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.napoleonapplication.CatalogPresenter
import com.example.napoleonapplication.Product
import com.example.napoleonapplication.R
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity: BaseActivity(), CatalogView {

    private val presenter = CatalogPresenter()
    private val adapter = CategoryAdapter {category ->
        presenter.removeItem(category)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)


        InfoProductBtn.setOnClickListener{
            val intent = Intent(this,InfoProductActivity::class.java)
            startActivity(intent)
        }

        BasketBtn.setOnClickListener{
            val intent = Intent(this,BasketActivity::class.java)
            startActivity(intent)
        }

        categoryRv.layoutManager = LinearLayoutManager(this)
        categoryRv.adapter = adapter
        presenter.setData()
        presenter.attachView(this)
    }

    override fun setCategories(list: MutableList<Product>) {
        adapter.setData(list)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }


}