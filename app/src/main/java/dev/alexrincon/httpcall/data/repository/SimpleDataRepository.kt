package dev.alexrincon.httpcall.data.repository

import dev.alexrincon.httpcall.data.ApiClient
import dev.alexrincon.httpcall.data.api.SimpleDataApi
import dev.alexrincon.httpcall.data.api.model.SimpleDataResponse
import retrofit2.Response

class SimpleDataRepository {

    private val simpleDataApi: SimpleDataApi = ApiClient.retrofit.create(SimpleDataApi::class.java)

    suspend fun getSimpleData(): Response<SimpleDataResponse> {
        return simpleDataApi.getData()
    }
}
