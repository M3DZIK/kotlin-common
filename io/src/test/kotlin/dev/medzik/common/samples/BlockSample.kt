package dev.medzik.common.samples

import dev.medzik.common.ioBlock
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BlockSample {
    @Test
    fun blockSample() = runBlocking {
        val result = ioBlock {
            "Hello, World!"
        }

        assertEquals("Hello, World!", result())
    }
}
