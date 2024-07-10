package dev.medzik.common

/**
 * Type alias that represents a suspended function that returns a value.
 *
 * @sample dev.medzik.common.samples.IOSample.ioSample
 */
typealias IO<T> = suspend () -> T
