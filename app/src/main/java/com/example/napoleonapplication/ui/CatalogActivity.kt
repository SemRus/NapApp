package com.example.napoleonapplication.ui

import android.content.Intent
import android.os.Bundle
import android.view.ViewAnimationUtils
import com.example.napoleonapplication.R
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity: BaseActivity() {

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

    }


}