package uz.data.messengerappui.model

data class Message(
    val image: String,
    val fullname: String,
    val message: String,
    val time: String,
    val isOnline: Boolean = false
)
