package dev.alexrincon.httpcall.data.api

import dev.alexrincon.httpcall.data.api.model.SimpleDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleDataApi {
    /**
     * BASE URL = "https://jsonplaceholder.typicode.com/"
     */
    @Headers("Content-Type: application/json")
    @GET("todos/1")
    suspend fun getData(): Response<SimpleDataResponse>
}
