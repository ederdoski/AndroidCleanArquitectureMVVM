package com.adrena.basearchitect.core.base

import retrofit2.Response
import java.net.HttpURLConnection
import javax.net.ssl.HttpsURLConnection

class NetworkResponse<T>(responseNetwork: Response<T>) {

     var response: T? = null
     var exception: Exception? = null
     private val ERROR_BUSSINES = 422

    init {
        when (responseNetwork.code()) {
            HttpsURLConnection.HTTP_OK,
            HttpsURLConnection.HTTP_CREATED,
            HttpsURLConnection.HTTP_NO_CONTENT,
            HttpsURLConnection.HTTP_ACCEPTED -> response = responseNetwork.body()
            HttpURLConnection.HTTP_FORBIDDEN,
            HttpURLConnection.HTTP_BAD_REQUEST,
            ERROR_BUSSINES -> exception = Exception(responseNetwork.errorBody().toString())
            else -> { HttpURLConnection.HTTP_BAD_REQUEST }
        }
    }

}