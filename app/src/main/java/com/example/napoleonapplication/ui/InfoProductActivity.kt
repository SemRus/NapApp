package com.example.napoleonapplication.ui

import android.content.Intent
import android.os.Bundle
import com.example.napoleonapplication.R
import kotlinx.android.synthetic.main.info_product.*

class InfoProductActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_product)

        BackBtnInfoProductAct.setOnClickListener {
            finish()
        }

    }
}