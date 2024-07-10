package dev.medzik.common

/**
 * Transforms the value returned by this `IO<T>` monad using the provided function `block`.
 *
 * This function takes a lambda IO [block] that transforms a value of type `T` to a value of type `R`.
 * It first calls the original `IO<T>` function to get the value of type `T`.
 * Then, it applies the [block] function to the obtained value, transforming it to a value of type `R`.
 * Finally, it returns a new `IO<R>` monad containing the transformed value.
 *
 * @param block A lambda IO function that takes a value of type `T` and returns a value of type `R`.
 * @return A new `IO<R>` monad containing the transformed value.
 *
 * @sample dev.medzik.common.MapTest.mapSample
 * @sample dev.medzik.common.MapTest.mapAndFlatMapSample
 */
inline fun <T, R> IO<T>.map(
    crossinline block: suspend (T) -> R
): IO<R> = ioBlock {
    val t = invoke()
    val r = block(t)
    r
}

/**
 * Transforms this `IO<T>` monad by applying a function that returns another `IO<R>` monad.
 *
 * This function takes a lambda IO [block] that transforms a value of type `T` to a new `IO<R>` monad.
 * It first calls the original `IO<T>` function to get the value of type `T`.
 * Then, it calls the [block] function with the obtained value, resulting in a new `IO<R>` monad.
 * Finally, it returns this new `IO<R>` monad, effectively chaining asynchronous operations.
 *
 * @param block A lambda IO function that takes a value of type `T` and returns a new `IO<R>` monad.
 * @return A new `IO<R>` monad resulting from the transformation.
 *
 * @sample dev.medzik.common.MapTest.flatMapSample
 * @sample dev.medzik.common.MapTest.mapAndFlatMapSample
 */
inline fun <T, R> IO<T>.flatMap(
    crossinline block: suspend (T) -> IO<R>
): IO<R> = {
    val t = invoke()
    val r = block(t)
    r()
}
