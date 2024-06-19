package com.vgaidarji.github.profile

import android.content.Context
import com.vgaidarji.github.app.di.ProfileModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [ProfileModuleDependencies::class])
interface ProfileComponent {

    fun inject(viewModel: ProfileViewModel)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(profileModuleDependencies: ProfileModuleDependencies): Builder
        fun build(): ProfileComponent
    }
}
