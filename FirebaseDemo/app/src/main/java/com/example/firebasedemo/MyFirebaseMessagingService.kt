package com.example.firebasedemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val chanelId = "notification_channel"
    private val channelName = "NotifyMsg"


    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FirebaseToken", token)

        //fji-axvJQEuIoy2z5g3xER:APA91bFm5VZ46z98jNjSrcTxzaOPQbM0rGEgk7DDKQwvYuUxyo2eLjU2BFyiu_4dK3k9uSW9T_7rxX1Zfg82qC1yaU9YkVnAgfIHSw8PFJUCNII36aBLJGDxJcbniYdLtIpTEHtFeRlZ
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        message.notification!!.let {
            notifyMessage(it.title, it.body)

        }


    }

    private fun notifyMessage(notiTitle: String?, notiBody: String?) {

        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val notificationChannel =
                NotificationChannel(chanelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)


            notificationManager.createNotificationChannel(notificationChannel)
        }


        val notification: NotificationCompat.Builder = NotificationCompat.Builder(
            applicationContext, "notification_channel"
        ).setContentTitle(notiTitle)
            .setContentText(notiBody)
            .setSmallIcon(R.drawable.ic_notifications)
            .setAutoCancel(true)
            .setOnlyAlertOnce(true)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000))

        notificationManager.notify(1, notification.build())


    }


}