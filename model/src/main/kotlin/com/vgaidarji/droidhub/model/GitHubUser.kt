package com.vgaidarji.droidhub.model

data class GitHubUser(
    val login: String,
    val id: Int,
    val avatarUrl: String,
    val url: String,
    val starredUrl: String,
    val reposUrl: String,
    val name: String,
    val company: String,
    val blog: String,
    val location: String,
    val email: String,
    val bio: String,
    val publicRepositoriesCount: Int,
    val followersCount: Int,
    val followingCount: Int
) {
    companion object {
        val NO_USER = GitHubUser(
            login = "",
            id = -1,
            avatarUrl = "",
            url = "",
            starredUrl = "",
            reposUrl = "",
            name = "",
            company = "",
            blog = "",
            location = "",
            email = "",
            bio = "",
            publicRepositoriesCount = 0,
            followersCount = 0,
            followingCount = 0
        )
    }
}
