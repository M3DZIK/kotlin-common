package dev.medzik.common.io

import kotlinx.coroutines.*

/**
 * Executes the IO operation on the current thread blocking it until its completion.
 *
 * @return The result of the IO function.
 *
 * @sample dev.medzik.common.io.InvokeTest.runBlockingSample
 */
fun <T> IO<T>.runBlocking(): T = runBlocking { invoke() }

/**
 * Executes the IO operation on given coroutine scope.
 *
 * @param scope The coroutine scope on which the IO function will be launched.
 * @return A [Job] representing the launched coroutine operation.
 * The job can be used to cancel the operation if needed.
 *
 * @sample dev.medzik.common.io.InvokeTest.launchInSample
 */
fun <T> IO<T>.launchIn(scope: CoroutineScope): Job = scope.launch { invoke() }

/**
 * Transforms this `IO<T>` operations to execute on given coroutine dispatcher.
 *
 * @param dispatcher The coroutine dispatcher on which the IO function will be launched.
 * @return A new `IO<T>` that will execute on the given coroutine dispatcher.
 *
 * @sample dev.medzik.common.io.InvokeTest.dispatcherSample
 */
fun <T> IO<T>.dispatcher(dispatcher: CoroutineDispatcher): IO<T> = ioBlock {
    withContext(dispatcher) {
        invoke()
    }
}
