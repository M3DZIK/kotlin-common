package dev.medzik.common.io

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

/**
 * Performs a parallel mapping operation on the elements of this iterable collection using the provided [f] function.
 * The [f] function is invoked on each element in a separate coroutine, allowing for concurrent execution.
 *
 * @param f The function to apply to each element. This function must be a suspend function.
 * @return A list containing the results of applying the [f] function to each element in this iterable collection.
 *
 * @sample dev.medzik.common.io.ParallelTest.parallelMapSample
 */
suspend fun <T, R> Iterable<T>.parallelMap(f: suspend (T) -> R): List<R> = coroutineScope {
    map { async { f(it) } }.awaitAll()
}

/**
 * Performs a parallel iteration over the elements of this iterable collection using the provided [f] function.
 * The [f] function is invoked on each element in a separate coroutine, allowing for concurrent execution.
 *
 * @param f The function to apply to each element. This function must be a suspend function.
 *
 * @sample dev.medzik.common.io.ParallelTest.parallelForEachSample
 */
suspend fun <T> Iterable<T>.parallelForEach(f: suspend (T) -> Unit) {
    parallelMap(f)
}
