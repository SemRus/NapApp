package com.example.napoleonapplication.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import com.example.napoleonapplication.Presenter
import com.example.napoleonapplication.Product
import com.example.napoleonapplication.ProductView
import com.example.napoleonapplication.R
import com.example.napoleonapplication.ui.BasketActivity.Companion.PRODUCT_ID
import kotlinx.android.synthetic.main.activity_main.*

class CheckoutActivity : BaseActivity(),
    ProductView {

    private val presenter = Presenter()
    private val products =
        Product("iphone Case", 150.0, 30)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val productID = intent.extras?.getInt(PRODUCT_ID, -1)

        Log.d(tag, productID.toString())

        presenter.attachView(this)

        product.text = "Товары: " + products.title
        price.text = products.price.toString()
        salePersent.text = products.salePercent.toString() + " %"
        finalPrice.text = products.calcDiscountPrice().toString()

        BackBtnCheckoutAct.setOnClickListener{
            finish()
        }
        setListeners()

    }

    private fun setListeners() {
        checkoutPhoneNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.validatePhone(checkoutPhoneNumber.text.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })

    }

        override fun showErrorForPhone(visible: Boolean) {
            checkoutPhoneNumber.showError(visible)
        }

    private fun EditText.showError(visible: Boolean){
        val drawable = if (visible) R.drawable.ic_error else 0

        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }

}
