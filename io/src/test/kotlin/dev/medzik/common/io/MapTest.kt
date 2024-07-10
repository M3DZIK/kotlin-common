package dev.medzik.common.io

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MapTest {
    @Test
    fun mapSample() {
        val block = ioBlock {
            "Hello, World!"
        }

        val result = block
            .map { it.reversed() }
            .runBlocking()

        assertEquals("!dlroW ,olleH", result)
    }

    @Test
    fun flatMapSample() {
        // get some data
        val data = ioBlock {
            "some data content"
        }

        fun saveData(data: String) = ioBlock {
            println(data)

            return@ioBlock
        }

        data
            .flatMap { value ->
                saveData(value)
            }
            .runBlocking()
    }

    @Test
    fun mapAndFlatMapSample() {
        // get some data
        val data = ioBlock {
            "some data content"
        }

        fun saveData(data: String) = ioBlock {
            println(data)

            return@ioBlock
        }

        data
            .map {
                // reverse the data content
                it.reversed()
            }
            .flatMap { value ->
                saveData(value)
            }
            .runBlocking()
    }
}
