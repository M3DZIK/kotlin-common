package dev.medzik.common.io

/**
 * Type alias that represents a suspended function that returns a value.
 *
 * @sample dev.medzik.common.io.IOTest.ioSample
 */
typealias IO<T> = suspend () -> T
