package dev.medzik.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Executes the IO operation on the current thread blocking it until its completion.
 *
 * @return The result of the IO function.
 *
 * @sample dev.medzik.common.samples.InvokeSample.runBlockingSample
 */
fun <T> IO<T>.runBlocking(): T = runBlocking { invoke() }

/**
 * Executes the IO operation on given coroutine scope.
 *
 * @param scope The coroutine scope on which the IO function will be launched.
 * @return A [Job] representing the launched coroutine operation.
 * The job can be used to cancel the operation if needed.
 *
 * @sample dev.medzik.common.samples.InvokeSample.launchInSample
 */
fun <T> IO<T>.launchIn(scope: CoroutineScope): Job = scope.launch { invoke() }
