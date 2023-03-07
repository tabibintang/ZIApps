package co.id.zeelandia.ziapps.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val userId: String,
    val displayName: String,
    val workerId: String,
    val token: String,
)