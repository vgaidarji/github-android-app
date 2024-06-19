package com.vgaidarji.github.api

import com.vgaidarji.github.api.model.GitHubUserResponse
import com.vgaidarji.github.model.GitHubUser
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

class GitHubUsersApiClient(retrofit: Retrofit) : GitHubUsersApi {
    interface GitHubUsersService {
        @GET("users/{name}")
        suspend fun getGitHubUser(@Path("name")name: String): GitHubUserResponse
    }

    private val service = retrofit.create(GitHubUsersService::class.java)

    override suspend fun getGitHubUser(name: String): GitHubUser {
        return withContext(IO) {
            service.getGitHubUser(name).toModel()
        }
    }
}
