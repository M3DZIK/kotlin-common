package dev.medzik.common.samples

import dev.medzik.common.catchException
import dev.medzik.common.ioBlock
import dev.medzik.common.runBlocking
import org.junit.jupiter.api.Test
import java.io.IOException

class ExceptionSample {
    @Test
    fun catchExceptionSample() {
        val ioOperation = ioBlock {
            throw IOException("Test exception")
        }

        ioOperation
            .catchException { e ->
                println("Caught exception: ${e.message}")
            }
            .runBlocking()
    }
}
