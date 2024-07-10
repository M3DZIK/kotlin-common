package dev.medzik.common

/**
 * Handles errors that may occur during the execution of an [IO] operation.
 *
 * @param shouldHandle A function that determines whether the caught exception should be handled or not.
 * @param block A suspend function that will be invoked when the exception is to be handled.
 *
 * @sample
 */
inline fun <T> IO<T>.catchException(
    crossinline shouldHandle: (Throwable) -> Boolean = { true },
    crossinline block: suspend (Throwable) -> T
): IO<T> = ioBlock {
    try {
        invoke()
    } catch (e: Throwable) {
        if (shouldHandle(e)) block(e) else throw e
    }
}
