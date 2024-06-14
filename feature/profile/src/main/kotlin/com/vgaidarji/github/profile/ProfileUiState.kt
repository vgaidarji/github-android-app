package com.vgaidarji.github.profile

import com.vgaidarji.github.model.GitHubUser

data class ProfileUiState(
    val gitHubUser: GitHubUser = GitHubUser.NO_USER,
    val isLoading: Boolean = false
) {

    companion object {
        val NO_USER = ProfileUiState()
    }
}