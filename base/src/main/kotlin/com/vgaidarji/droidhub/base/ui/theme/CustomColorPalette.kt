package com.vgaidarji.droidhub.base.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColorsPalette(
    val avatarBackground: Color = Color.Unspecified,
    val avatarBorder: Color = Color.Unspecified,
)

val LightAvatarBackground: Color = Color.Gray
val LightAvatarBorder: Color = Color.LightGray

val DarkAvatarBackground: Color = Color.Gray
val DarkAvatarBorder: Color = Color.LightGray

val LightCustomColorsPalette = CustomColorsPalette(
    avatarBackground = LightAvatarBackground,
    avatarBorder = LightAvatarBorder
)

val DarkCustomColorsPalette = CustomColorsPalette(
    avatarBackground = DarkAvatarBackground,
    avatarBorder = DarkAvatarBorder
)

val LocalCustomColorsPalette = staticCompositionLocalOf { CustomColorsPalette() }

val MaterialTheme.customColorsPalette: CustomColorsPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalCustomColorsPalette.current