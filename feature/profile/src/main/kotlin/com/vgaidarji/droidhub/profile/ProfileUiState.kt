package com.vgaidarji.droidhub.profile

import com.vgaidarji.droidhub.model.GitHubUser

data class ProfileUiState(
    val gitHubUser: GitHubUser = GitHubUser.NO_USER,
    val isLoading: Boolean = false
) {

    companion object {
        val NO_USER = ProfileUiState()
    }
}
