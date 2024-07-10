package dev.medzik.common

import kotlin.coroutines.cancellation.CancellationException

/**
 * Handles errors that may occur during the execution of an [IO] operation.
 *
 * @param shouldHandle A function that determines whether the caught exception should be handled or not.
 * @param block A suspend function that will be invoked when the exception is to be handled.
 *
 * @sample dev.medzik.common.samples.ExceptionSample.catchExceptionSample
 */
inline fun <T> IO<T>.catchException(
    crossinline shouldHandle: (Throwable) -> Boolean = { true },
    crossinline block: suspend (Throwable) -> T
): IO<T> = ioBlock {
    try {
        invoke()
    } catch (e: Throwable) {
        if (this is CancellationException) {
            throw this
        }

        if (shouldHandle(e)) block(e) else throw e
    }
}
