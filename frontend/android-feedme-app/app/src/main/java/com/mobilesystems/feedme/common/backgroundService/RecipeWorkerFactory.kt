package com.mobilesystems.feedme.common.backgroundService

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.mobilesystems.feedme.data.repository.WorkerRepositoryImpl
import javax.inject.Inject

class RecipeWorkerFactory @Inject constructor(
    private val workerRepository: WorkerRepositoryImpl) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): CoroutineWorker? {
        return when(workerClassName) {
            RecipeWorker::class.java.name ->
                RecipeWorker(appContext, workerParameters, workerRepository)
            else ->
                // Return null, so that the base class can delegate to the default WorkerFactory.
                null
        }
    }
}