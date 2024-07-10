package dev.medzik.common.io

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IOTest {
    @Test
    fun ioSample() {
        val resultBlock: IO<String> = ioBlock {
            "Hello, World!"
        }

        val result: String = resultBlock.runBlocking()

        assertEquals("Hello, World!", result)
    }
}
