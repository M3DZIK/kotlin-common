package dev.medzik.common.samples

import dev.medzik.common.flatMap
import dev.medzik.common.ioBlock
import dev.medzik.common.map
import dev.medzik.common.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class MapSample {
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
