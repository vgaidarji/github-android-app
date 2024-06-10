package com.vgaidarji.github.api

import com.vgaidarji.github.model.GitHubUser

interface UsersApi {
    suspend fun getUser(name: String): GitHubUser
}
