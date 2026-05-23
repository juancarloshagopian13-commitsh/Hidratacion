package com.example.hidratacion

import android.R
import android.annotation.SuppressLint
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class WaterReminderWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    @SuppressLint("MissingPermission")
    override fun doWork(): Result {
        val builder = NotificationCompat.Builder(applicationContext, "WATER_REMINDER_CHANNEL")
            .setSmallIcon(R.drawable.ic_dialog_info)
            .setContentTitle("Recordatorio de Hidratación")
            .setContentText("¡Es hora de beber agua!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)


        with(NotificationManagerCompat.from(applicationContext)) {
            notify(1001, builder.build())
        }

        return Result.success()
    }
}