package com.example.cardscanner.ui.result.viewmodel

import com.example.cardscanner.network.models.CardDetail


sealed class UiState {

    data class LOADING(val loading: Boolean = false): UiState()

    data class SUCCESS(val data:CardDetail): UiState()
    data class ERROR(val errorMessage: String): UiState()



}