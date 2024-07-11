package dev.medzik.common.io

import kotlinx.coroutines.flow.flow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlowTest {
    @Test
    fun flowSample() {
        val flow = flow { emit(100) }
        // convert flow to IO function
        val io = flow.toIO()
        // wait for a result
        val result = io.runBlocking()

        assertEquals(100, result)
    }
}
