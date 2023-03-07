package co.id.zeelandia.ziapps.services

import co.id.zeelandia.ziapps.response.BasicResponse
import co.id.zeelandia.ziapps.response.LoginResponse
import co.id.zeelandia.ziapps.response.NPDRequestResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("npd-list-all")
    fun getAllNPDRequest(
        @Header("Authorization") token: String
    ): Call<List<NPDRequestResponse>>

    @FormUrlEncoded
    @POST("login")
    fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @GET("logout")
    fun logout(
        @Header("Authorization") token: String
    ): Call<BasicResponse>
}