package com.example.napoleonapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductView {

    private val presenter = Presenter()
    private val products = Product("iphone Case", 150.0, 30)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        product.text = "Товары: " + products.title
        price.text = products.price.toString()
        salePersent.text = products.salePercent.toString() + " %"
        finalPrice.text = products.calcDiscountPrice().toString()

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

}
