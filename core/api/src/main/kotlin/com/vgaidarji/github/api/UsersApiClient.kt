package com.vgaidarji.github.api

import com.vgaidarji.github.api.model.GitHubUserResponse
import com.vgaidarji.github.model.GitHubUser
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

class UsersApiClient(retrofit: Retrofit) : UsersApi {
    interface UsersService {
        @GET("users/{name}")
        suspend fun getUser(@Path("name")name: String): GitHubUserResponse
    }

    private val service = retrofit.create(UsersService::class.java)

    override suspend fun getUser(name: String): GitHubUser {
        return withContext(IO) {
            service.getUser(name).toModel()
        }
    }
}
