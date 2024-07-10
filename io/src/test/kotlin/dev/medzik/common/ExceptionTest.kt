package dev.medzik.common

import org.junit.jupiter.api.Test
import java.io.IOException

class ExceptionTest {
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
