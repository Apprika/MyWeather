package co.za.kudzi.myweather.network


sealed class NetworkResult<out R> private constructor() {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data object Loading : NetworkResult<Nothing>()
    data class Error(val message: String?, val code: Int) : NetworkResult<Nothing>()
}