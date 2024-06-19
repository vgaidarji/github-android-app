package com.vgaidarji.github.api

import com.vgaidarji.github.model.GitHubUser

interface GitHubUsersApi {
    suspend fun getGitHubUser(name: String): GitHubUser
}
