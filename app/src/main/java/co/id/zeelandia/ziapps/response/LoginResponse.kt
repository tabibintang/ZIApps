package co.id.zeelandia.ziapps.response

import co.id.zeelandia.ziapps.data.model.User
import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("access_token")
	val accessToken: String,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("token_type")
	val tokenType: String,

	val user: User,
)
