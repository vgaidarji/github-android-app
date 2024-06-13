package com.vgaidarji.github.api.di

import com.vgaidarji.github.api.ApiTokenInterceptor
import com.vgaidarji.github.api.GitHubUsersApi
import com.vgaidarji.github.api.GitHubUsersApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
  private val gitHubApiBaseUrl = "https://api.github.com/"

  @ExperimentalSerializationApi
  @Singleton
  @Provides
  fun provideConverterFactory(): Converter.Factory {
    return Json {
      isLenient = true
      ignoreUnknownKeys = true
    }.asConverterFactory("application/json".toMediaType())
  }

  @Singleton
  @Provides
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .connectTimeout(10L, TimeUnit.SECONDS)
      .writeTimeout(10L, TimeUnit.SECONDS)
      .readTimeout(30L, TimeUnit.SECONDS)
      .addInterceptor(ApiTokenInterceptor())
      .build()
  }

  @Singleton
  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit {
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(gitHubApiBaseUrl)
      .addConverterFactory(converterFactory)
      .build()
  }

  @Singleton
  @Provides
  fun provideUserApi(retrofit: Retrofit): GitHubUsersApi {
    return GitHubUsersApiClient(retrofit)
  }
}
