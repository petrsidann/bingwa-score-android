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
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .build()
                chain.proceed(request)
            }
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
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    
    @Provides
    @Singleton
    fun provideTransactionDao(database: AppDatabase): TransactionDao {
        return database.transactionDao()
    }
    
    @Provides
    @Singleton
    fun provideOfferDao(database: AppDatabase): OfferDao {
        return database.offerDao()
    }
    
    @Provides
    @Singleton
    fun provideCustomerDao(database: AppDatabase): CustomerDao {
        return database.customerDao()
    }
    
    @Provides
    @Singleton
    fun provideUserPreferences(@ApplicationContext context: Context): UserPreferences {
        return UserPreferences(context)
    }
    
    @Provides
    @Singleton
    fun provideAuthRepository(
        apiService: ApiService,
        userPreferences: UserPreferences
    ): AuthRepository {
        return AuthRepository(apiService, userPreferences)
    }
    
    @Provides
    @Singleton
    fun provideBundleRepository(
        apiService: ApiService,
        userPreferences: UserPreferences
    ): BundleRepository {
        return BundleRepository(apiService, userPreferences)
    }
    
    @Provides
    @Singleton
    fun provideTransactionRepository(
        transactionDao: TransactionDao,
        offerDao: OfferDao,
        customerDao: CustomerDao
    ): TransactionRepository {
        return TransactionRepository(transactionDao, offerDao, customerDao)
    }
    
    @Provides
    @Singleton
    fun provideOfferRepository(offerDao: OfferDao): OfferRepository {
        return OfferRepository(offerDao)
    }
    
    @Provides
    @Singleton
    fun provideCustomerRepository(customerDao: CustomerDao): CustomerRepository {
        return CustomerRepository(customerDao)
    }
    
    @Provides
    @Singleton
    fun provideAdminRepository(
        adminApiService: AdminApiService,
        userPreferences: UserPreferences
    ): AdminRepository {
        return AdminRepository(adminApiService, userPreferences)
    }
}
