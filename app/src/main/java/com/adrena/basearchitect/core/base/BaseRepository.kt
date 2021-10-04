package com.adrena.basearchitect.core.base

import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

open class BaseRepository {

}


sealed class Response<out T> {
    data class Success<out T>(val successData: T) : Response<T>()
    data class Failure<out R : Exception>(val errorData: R) : Response<Nothing>()
    data class State<Nothing>(val loader: Boolean) : Response<kotlin.Nothing>()
}
