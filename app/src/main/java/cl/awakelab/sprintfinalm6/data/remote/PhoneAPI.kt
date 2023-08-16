package cl.awakelab.sprintfinalm6.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface PhoneAPI {
    @GET("products/")
    suspend fun getData(): Response<List<Phone>>

}