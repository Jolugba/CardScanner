package com.example.cardscanner.ui.scancard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardscanner.ui.Inputcard.InputViewModel
import com.example.cardscanner.util.Constants


class ScanCardViewModel  :
    ViewModel() {
    private val _state = MutableLiveData<InputViewModel.ViewState>()
    val state: LiveData<InputViewModel.ViewState> = _state
    private val _isEnabled = MutableLiveData(false)
    val isEnabled: LiveData<Boolean> get() = _isEnabled

    private fun validateNumber(number: String): Boolean {
        return when {
            number.isNullOrEmpty()  -> {
                _state.value = InputViewModel.ViewState.ERROR("Card Number cannot be blank")
                _isEnabled.postValue(false)
                false
            }
            // this value is 6 because card number acc starts from 6
            number.length < Constants.AppConstants.MINIMUM_CARD_NUMBER -> {
                _state.value = InputViewModel.ViewState.ERROR("Card Number is incomplete")
                _isEnabled.postValue(false)
                false
            }
            else -> {
                _isEnabled.postValue(true)
                true}
        }
    }
    fun getNumber(number: String) {
        if (validateNumber(number)) {
            _state.value = InputViewModel.ViewState.SUCCESS(number)

        }
    }



}





