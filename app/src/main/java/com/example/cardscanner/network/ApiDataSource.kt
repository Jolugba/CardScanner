package com.example.cardscanner.network


import javax.inject.Inject


class ApiDataSource @Inject constructor(private val apiService: CardService) {
    suspend fun fetchCard(
        cardNumber: Int
    ) = apiService.getCard(cardNumber)


}
