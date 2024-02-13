package com.example.cardscanner.util

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


fun <T : Any?> LifecycleOwner.observe(data: LiveData<T>, body: (T) -> Unit) {
    data.observe(this, Observer(body))
}

fun parseError(e: Exception, errorCallback: ((String) -> Unit)) {
    when (e) {
        is UnknownHostException, is SocketTimeoutException, is ConnectException -> {
            errorCallback("Check your internet Connection")
        }
        else -> {
            errorCallback("Something went wrong")
        }
    }
    e.printStackTrace()
}

fun ViewModel.runIO(function: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch(Dispatchers.IO) { function() }
}