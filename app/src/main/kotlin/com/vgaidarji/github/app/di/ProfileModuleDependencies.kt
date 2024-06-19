package com.vgaidarji.github.app.di

import com.vgaidarji.github.repository.GitHubUserRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface ProfileModuleDependencies {
    fun provideGitHubUserRepository(): GitHubUserRepository
}
