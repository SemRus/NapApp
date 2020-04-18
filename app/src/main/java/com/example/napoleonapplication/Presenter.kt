package com.example.napoleonapplication


import moxy.MvpPresenter

class Presenter: MvpPresenter<ProductView>() {

    fun validatePhone(phone: String){
        val validationResult = if(phone.startsWith("8"))
            phone.length == 11
        else
            phone.startsWith("+7") && phone.length == 12

        viewState.showErrorForPhone(!validationResult)
    }

}