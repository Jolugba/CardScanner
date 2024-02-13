package com.example.cardscanner.network.models

data class CardDetail(
    val brand: String, val type: String, val bank: Bank, val country: Country
)


data class Bank(val name: String)

data class Country(val name: String)
