package dev.medzik.common.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun truncateSample() {
        val input = "Hello, World!"
        val expected = "Hello, Wor..."
        val result = input.truncate(10)
        assertEquals(expected, result)

        val input2 = "short text"
        val result2 = input2.truncate(10)
        assertEquals(input2, result2)
    }
}
