package com.vgaidarji.github.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vgaidarji.github.repository.GitHubUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val gitHubUserRepository: GitHubUserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState.NO_USER)
    val uiState: StateFlow<ProfileUiState> get() = _uiState
    // TODO: parametrize to allow for loading arbitrary user's profile
    val GITHUB_USER_NAME = "vgaidarji"

    init {
        viewModelScope.launch {
            runCatching {
                _uiState.value = _uiState.value.copy(isLoading = true)
                gitHubUserRepository.getGitHubUser(GITHUB_USER_NAME)
            }.onSuccess { gitHubUser ->
                _uiState.value = _uiState.value.copy(gitHubUser = gitHubUser, isLoading = false)
            }.onFailure { error ->
                _uiState.value = _uiState.value.copy(isLoading = false)
                // TODO: handle errors
            }
        }
    }
}