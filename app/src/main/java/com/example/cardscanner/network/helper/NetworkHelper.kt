package com.example.cardscanner.network.helper

import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T> apiCall(dispatcher: CoroutineDispatcher = Dispatchers.IO,
                        apiCall: suspend () -> T) : ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable){
            throwable.printStackTrace()
            when(throwable) {
                is IOException ->
                    ResultWrapper.Error(103, "Not connected to the internet")
                is UnknownHostException ->
                    ResultWrapper.Error(101, ErrorStatus.NO_CONNECTION)
                is SocketTimeoutException ->
                    ResultWrapper.Error(102, ErrorStatus.TIMEOUT)
                is HttpException -> {
                    val body = throwable.response()!!.errorBody()!!.string()
                    val gson = Gson()
                    try {
                        val response = gson.fromJson(body, APIErrorResponse::class.java)
                        if(response != null){
                            val apiErrorMessage = response.message
                            ResultWrapper.Error(401, apiErrorMessage)
                        } else {
                            ResultWrapper.Error(401, throwable.message())
                        }
                    } catch (exception: Exception){
                        ResultWrapper.Error(401, "An error occurred on the server")
                    }

                }
                is InternalError ->
                    ResultWrapper.Error(500, "An internal server error occurred")

                else -> {
                    ResultWrapper.Error(null, throwable.localizedMessage)
                }
            }
        }
    }

}


sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class Error(val code: Int? = null, val error: String): ResultWrapper<Nothing>()
}

class ErrorStatus {
    companion object {
        const val NO_CONNECTION = "Not Connected To The Internet"
        const val TIMEOUT = "Request has been Timed out"
    }
}


data class APIErrorResponse(
        val message: String
)
