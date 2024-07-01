package com.vgaidarji.droidhub.repository

import com.vgaidarji.droidhub.api.GitHubUsersApi
import com.vgaidarji.droidhub.model.GitHubUser
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