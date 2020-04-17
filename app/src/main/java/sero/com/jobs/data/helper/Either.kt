package sero.com.jobs.data.helper

sealed class Either<out Fail, out Success> {
    data class Failure<out Fail>(val fail: Fail) : Either<Fail, Nothing>()
    data class Successful<out Success>(val success: Success) : Either<Nothing, Success>()

    fun <Failure> fail(a: Failure) = Failure(a)
    fun <Success> success(b: Success) = Successful(b)
    suspend fun either(onFailure: suspend (Fail) -> Unit, onSuccess: suspend (Success) -> Unit): Any = when (this) {
        is Failure -> onFailure(fail)
        is Successful -> onSuccess(success)
    }
}