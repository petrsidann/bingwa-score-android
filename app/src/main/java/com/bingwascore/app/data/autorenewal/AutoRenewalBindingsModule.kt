package com.bingwascore.app.data.autorenewal

import com.bingwascore.app.domain.autorenewal.AutoRenewalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AutoRenewalBindingsModule {

    @Binds
    @Singleton
    abstract fun bindAutoRenewalRepository(impl: AutoRenewalRepositoryImpl): AutoRenewalRepository
}
