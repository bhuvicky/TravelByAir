package com.example.corecommon.util

import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

class DiskExecutor @Inject constructor() : Executor {

    private val executor: Executor = Executors.newSingleThreadExecutor()

    override fun execute(runnable: Runnable) {
        executor.execute(runnable)
    }
}