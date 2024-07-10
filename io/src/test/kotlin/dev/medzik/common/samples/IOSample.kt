package dev.medzik.common.samples

import dev.medzik.common.IO
import dev.medzik.common.ioBlock
import dev.medzik.common.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IOSample {
    @Test
    fun ioSample() {
        val resultBlock: IO<String> = ioBlock {
            "Hello, World!"
        }

        val result: String = resultBlock.runBlocking()

        assertEquals("Hello, World!", result)
    }
}
