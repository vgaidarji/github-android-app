package com.vgaidarji.droidhub.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.vgaidarji.droidhub.base.ui.component.ProgressView

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, profileViewModel: ProfileViewModel) {
    val uiState by profileViewModel.uiState.collectAsStateWithLifecycle()
    ProfileScreen(modifier, uiState)
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, uiState: ProfileUiState) {
    if (uiState.isLoading) {
        ProgressView()
    } else {
        Surface(modifier, color = MaterialTheme.colorScheme.background) {
            Column(
                modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileAvatar(avatarUrl = uiState.gitHubUser.avatarUrl)
                Text(uiState.gitHubUser.name, textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun ProfileAvatar(modifier: Modifier = Modifier, avatarUrl: String) {
    AsyncImage(
        model = avatarUrl,
        contentDescription = stringResource(id = R.string.content_description_profile_avatar),
        contentScale = ContentScale.Crop,
        modifier = modifier.size(200.dp).clip(CircleShape).background(Color.LightGray)
    )
}


