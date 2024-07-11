package dev.medzik.common.extensions

/**
 * Truncates the given string to the given length.
 *
 * @param maxLength Length of characters to which it will be truncated.
 * @return The truncated string.
 *
 * @sample dev.medzik.common.extensions.StringTest.truncateSample
 */
fun String.truncate(maxLength: Int): String = if (length > maxLength) take(maxLength) + "..." else this
