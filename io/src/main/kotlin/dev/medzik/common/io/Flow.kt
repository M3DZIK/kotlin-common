package dev.medzik.common.io

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

/**
 * Converts a Flow to an IO function, which is a suspended function that returns a single value.
 *
 * @return An IO that suspends until the first value is emitted from the Flow and returns it.
 *
 * @sample dev.medzik.common.io.FlowTest.flowSample
 */
fun <T> Flow<T>.toIO(): IO<T> = ioBlock { first() }
