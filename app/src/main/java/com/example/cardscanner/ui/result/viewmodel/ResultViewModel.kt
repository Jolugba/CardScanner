package com.example.cardscanner.ui.result.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardscanner.network.helper.ResultWrapper
import com.example.cardscanner.network.helper.apiCall
import com.example.cardscanner.network.repo.CardRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(private val repo: CardRepo) :
    ViewModel() {
    private val _state = MutableLiveData<UiState>()
    val state: LiveData<UiState> = _state

    fun fetchCardInfo(cardNumber: String){
        viewModelScope.launch {
            _state.postValue(UiState.LOADING(true))

            when(val result = apiCall {
                repo.fetchCardDetail(cardNumber.toInt())
            })
            {
                is ResultWrapper.Success -> {
                    _state.postValue(UiState.LOADING(false))
                    _state.postValue(UiState.SUCCESS(result.value))
                }

                is ResultWrapper.Error -> {
                    _state.postValue(UiState.LOADING(false))
                    _state.postValue(UiState.ERROR(result.error))
                }
            }
        }

    }

    }





