package com.bingwascore.app.data.remote

import com.bingwascore.app.data.auth.AuthRepository
import com.bingwascore.app.data.auth.OfflineAuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * MEGA B — binds the PART B contracts to their offline-first implementations.
 *
 * These bindings are the reason the engine can depend on [ApiService],
 * [DeviceRelay] and [AuthRepository] today: injecting any of them gives the
 * local, offline-safe version, which behaves identically to the remote one
 * until keys are provisioned.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteBindingsModule {

    @Binds
    @Singleton
    abstract fun bindApiService(impl: OfflineFirstApiService): ApiService

    @Binds
    @Singleton
    abstract fun bindDeviceRelay(impl: LocalDeviceRelay): DeviceRelay

    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: OfflineAuthRepository): AuthRepository
}