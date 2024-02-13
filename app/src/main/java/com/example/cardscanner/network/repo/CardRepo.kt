package com.example.cardscanner.network.repo


import com.example.cardscanner.network.ApiDataSource
import javax.inject.Inject


class CardRepo @Inject constructor(private val apiDataSource: ApiDataSource) {
    suspend fun fetchCardDetail(
        cardNumber:Int
    ) = apiDataSource.fetchCard(
      cardNumber=cardNumber
    )
}