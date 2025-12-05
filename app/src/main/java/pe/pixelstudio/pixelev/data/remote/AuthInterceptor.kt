package pe.pixelstudio.pixelev.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // TODO: Reemplazar "YOUR_TOKEN_HERE" con un token de API real
        val token = "YOUR_TOKEN_HERE"
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()
        return chain.proceed(request)
    }
}
