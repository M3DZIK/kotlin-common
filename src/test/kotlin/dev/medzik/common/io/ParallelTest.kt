package dev.medzik.common.io

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ParallelTest {
    @Test
    fun parallelMapSample() = runBlocking {
        val numbers = listOf(1, 2, 3, 4, 5)
        val squares = numbers.parallelMap { it * it }
        assertEquals(listOf(1, 4, 9, 16, 25), squares)
    }

    @Test
    fun parallelForEachSample() = runBlocking {
        val numbers = listOf(1, 2, 3, 4, 5)
        numbers.parallelForEach { println(it) }
    }
}
