package com.bingwascore.app.di

import com.bingwascore.app.BuildConfig
import com.bingwascore.app.data.preferences.UserPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @Named("BASE_URL")
    fun provideBaseUrl(userPreferences: UserPreferences): String {
        return userPreferences.serverUrl.value
            .takeIf { it.isNotBlank() } ?: BuildConfig.BASE_URL
    }
}
