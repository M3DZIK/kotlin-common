package dev.medzik.common

/**
 * Type alias that represents a suspended function that returns a value.
 *
 * @sample dev.medzik.common.IOTest.ioSample
 */
typealias IO<T> = suspend () -> T
