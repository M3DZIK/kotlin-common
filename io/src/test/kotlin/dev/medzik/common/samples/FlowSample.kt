package dev.medzik.common.samples

import dev.medzik.common.runBlocking
import dev.medzik.common.toIO
import kotlinx.coroutines.flow.flow
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FlowSample {
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
