package dev.medzik.common.io

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InvokeTest {
    @Test
    fun runBlockingSample() {
        val result = ioBlock {
            "Hello, World!"
        }

        // run the io block on the current thread and wait for it to complete
        val resultString = result.runBlocking()

        assertEquals("Hello, World!", resultString)
    }

    @Test
    fun launchInSample() = runBlocking {
        val scope = CoroutineScope(Dispatchers.IO)

        val block = ioBlock {
            delay(1000)
        }

        // launch the io block in the given coroutine scope
        val job = block.launchIn(scope)

        // wait for the coroutine to complete
        job.join()
    }
}
