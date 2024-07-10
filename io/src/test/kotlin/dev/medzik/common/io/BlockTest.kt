package dev.medzik.common.io

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BlockTest {
    @Test
    fun blockSample() = runBlocking {
        val result = ioBlock {
            "Hello, World!"
        }

        assertEquals("Hello, World!", result())
    }

    @Test
    fun blockWithContextSample() = runBlocking {
        val result = ioBlock(Dispatchers.IO) {
            "Hello, World!"
        }

        assertEquals("Hello, World!", result())
    }
}
