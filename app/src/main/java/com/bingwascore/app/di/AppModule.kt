package com.bingwascore.app.di

import android.content.Context
import androidx.room.Room
import com.bingwascore.app.data.local.AppDatabase
import com.bingwascore.app.data.local.CustomerDao
import com.bingwascore.app.data.local.OfferDao
import com.bingwascore.app.data.local.TransactionDao
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.AdminApiService
import com.bingwascore.app.data.remote.ApiService
import com.bingwascore.app.data.repository.AdminRepository
import com.bingwascore.app.data.repository.AuthRepository
import com.bingwascore.app.data.repository.BundleRepository
import com.bingwascore.app.data.repository.CustomerRepository
import com.bingwascore.app.data.repository.OfferRepository
import com.bingwascore.app.data.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.bingwascore.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAdminApiService(retrofit: Retrofit): AdminApiService {
        return retrofit.create(AdminApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideTransactionDao(db: AppDatabase): TransactionDao = db.transactionDao()

    @Provides
    @Singleton
    fun provideOfferDao(db: AppDatabase): OfferDao = db.offerDao()

    @Provides
    @Singleton
    fun provideCustomerDao(db: AppDatabase): CustomerDao = db.customerDao()

    @Provides
    @Singleton
    fun provideUserPreferences(@ApplicationContext context: Context): UserPreferences {
        return UserPreferences(context)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(api: ApiService, prefs: UserPreferences): AuthRepository {
        return AuthRepository(api, prefs)
    }

    @Provides
    @Singleton
    fun provideBundleRepository(api: ApiService, prefs: UserPreferences): BundleRepository {
        return BundleRepository(api, prefs)
    }

    @Provides
    @Singleton
    fun provideTransactionRepository(
        tDao: TransactionDao,
        oDao: OfferDao,
        cDao: CustomerDao
    ): TransactionRepository {
        return TransactionRepository(tDao, oDao, cDao)
    }

    @Provides
    @Singleton
    fun provideOfferRepository(oDao: OfferDao): OfferRepository {
        return OfferRepository(oDao)
    }

    @Provides
    @Singleton
    fun provideCustomerRepository(cDao: CustomerDao): CustomerRepository {
        return CustomerRepository(cDao)
    }

    @Provides
    @Singleton
    fun provideAdminRepository(adminApi: AdminApiService, prefs: UserPreferences): AdminRepository {
        return AdminRepository(adminApi, prefs)
    }
}
