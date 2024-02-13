package com.example.cardscanner.ui.Inputcard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class InputViewModel :
    ViewModel() {
    private val _state = MutableLiveData<ViewState>()
    val state: LiveData<ViewState> = _state

    private fun validateNumber(number: String): Boolean {
        return when {
           number.isNullOrEmpty()  -> {
               _state.value = ViewState.ERROR("Card Number cannot be blank")
                false
            }
            number.length < 6  -> {
                _state.value = ViewState.ERROR("Card Number is incomplete")
                false
            }
            else -> true
        }
    }
    fun getNumber(number: String) {
        if (validateNumber(number)) {
            _state.value = ViewState.SUCCESS(number)

        }}

    sealed class ViewState {
        data class ERROR(val errorMessage: String) : ViewState()
        data class SUCCESS(val number:String) : ViewState()
    }



}





