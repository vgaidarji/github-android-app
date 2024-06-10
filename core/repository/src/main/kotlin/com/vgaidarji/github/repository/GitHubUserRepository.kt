package com.vgaidarji.github.repository

import com.vgaidarji.github.api.GitHubUsersApi
import com.vgaidarji.github.model.GitHubUser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubUserRepository @Inject constructor(
    private val gitHubUsersApi: GitHubUsersApi
) {

    suspend fun getGitHubUser(name: String): GitHubUser {
        return gitHubUsersApi.getGitHubUser(name)
    }
}