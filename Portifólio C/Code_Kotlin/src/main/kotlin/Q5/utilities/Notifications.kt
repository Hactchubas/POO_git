package Q5.utilities

import Q5.user_account.User

object NotificationService {

    private val notificationChannels: List<NotificationChannel> = listOf(
        EmailNotificationChannel(),
        SmsNotificationChannel()
    )

    fun notify(user: User, message: String) {
        notificationChannels.forEach { it.sendNotification(user, message) }
    }
}

interface NotificationChannel {
    fun sendNotification(user: User, message: String)
}

class EmailNotificationChannel : NotificationChannel {
    override fun sendNotification(user: User, message: String) {
        // Lógica para enviar email
        println("Email sent to ${user.email}: $message")
    }
}

class SmsNotificationChannel : NotificationChannel {
    override fun sendNotification(user: User, message: String) {
        // Lógica para enviar SMS
        println("SMS sent to ${user.phoneNumber}: $message")
    }
}
