package com.vgaidarji.github.api

import okhttp3.Interceptor
import okhttp3.Response

class ApiTokenInterceptor : Interceptor {
    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = BuildConfig.GITHUB_API_TOKEN
        val builder = chain.request().newBuilder()
        // GITHUB_API_TOKEN will be empty if nothing is set in local.properties
        if (token.isNotEmpty()) {
            builder.addHeader(AUTHORIZATION_HEADER, "token $token")
        }
        return chain.proceed(builder.build())
    }
}
