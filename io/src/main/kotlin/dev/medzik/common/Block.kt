package dev.medzik.common

/**
 * Wraps a given [IO] block into a new [IO] instance, allowing it to be used within other suspend functions.
 *
 * @param block The block to be wrapped into a new [IO] instance.
 * @return A new [IO] instance.
 *
 * @sample dev.medzik.common.BlockTest.blockSample
 */
inline fun <T> ioBlock(
    crossinline block: IO<T>,
): IO<T> = suspend {
    block()
}
