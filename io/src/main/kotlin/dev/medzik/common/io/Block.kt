package dev.medzik.common.io

import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * Wraps a given [IO] block into a new [IO] instance, allowing it to be used within other suspend functions.
 *
 * @param block The block to be wrapped into a new [IO] instance.
 * @return A new [IO] instance.
 *
 * @sample dev.medzik.common.io.BlockTest.blockSample
 */
inline fun <T> ioBlock(
    crossinline block: IO<T>
): IO<T> = suspend {
    block()
}

/**
 * Wraps a given [IO] block into a new [IO] instance, allowing it to be used within other suspend functions.
 *
 * @param context The coroutine context to be used for wrapping the block.
 * @param block The block to be wrapped into a new [IO] instance.
 * @return A new [IO] instance.
 *
 * @sample dev.medzik.common.io.BlockTest.blockWithContextSample
 */
inline fun <T> ioBlock(
    context: CoroutineContext,
    crossinline block: IO<T>
): IO<T> = ioBlock {
    withContext(context) {
        block()
    }
}
