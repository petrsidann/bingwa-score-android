package com.example.bingwahybrid.presentation.viewmodel;

import android.content.Context;
import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.LogoutUserUseCase;
import com.example.bingwahybrid.domain.repository.AccessibilityRepository;
import com.example.bingwahybrid.domain.repository.AccountHealthRepository;
import com.example.bingwahybrid.domain.repository.AppUpdateRepository;
import com.example.bingwahybrid.domain.repository.BalanceRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.repository.StatisticsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.security.TokenRefreshService;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.socket.SocketService;
import com.example.bingwahybrid.domain.statistics.usecase.GetCommissionForDatesUseCase;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import com.example.bingwahybrid.domain.usecase.RetryTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
    private final Provider<AccessibilityRepository> accessibilityRepositoryProvider;
    private final Provider<AccountHealthRepository> accountHealthRepositoryProvider;
    private final Provider<AppControl> appControlProvider;
    private final Provider<AppUpdateRepository> appUpdateRepositoryProvider;
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<BalanceRepository> balanceRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<GetCommissionForDatesUseCase> getCommissionForDatesUseCaseProvider;
    private final Provider<LogoutUserUseCase> logoutUserUseCaseProvider;
    private final Provider<RetryTransactionUseCase> retryTransactionUseCaseProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<SocketService> socketServiceProvider;
    private final Provider<StatisticsRepository> statisticsRepositoryProvider;
    private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;
    private final Provider<TokenRefreshService> tokenRefreshServiceProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private HomeViewModel_Factory(Provider<Context> contextProvider, Provider<AuthRepository> authRepositoryProvider, Provider<SubscriptionRepository> subscriptionRepositoryProvider, Provider<GetCommissionForDatesUseCase> getCommissionForDatesUseCaseProvider, Provider<LogoutUserUseCase> logoutUserUseCaseProvider, Provider<RetryTransactionUseCase> retryTransactionUseCaseProvider, Provider<AppControl> appControlProvider, Provider<AppUpdateRepository> appUpdateRepositoryProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<BalanceRepository> balanceRepositoryProvider, Provider<StatisticsRepository> statisticsRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<SocketService> socketServiceProvider, Provider<AccessibilityRepository> accessibilityRepositoryProvider, Provider<AccountHealthRepository> accountHealthRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider, Provider<TokenRefreshService> tokenRefreshServiceProvider) {
        this.contextProvider = contextProvider;
        this.authRepositoryProvider = authRepositoryProvider;
        this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
        this.getCommissionForDatesUseCaseProvider = getCommissionForDatesUseCaseProvider;
        this.logoutUserUseCaseProvider = logoutUserUseCaseProvider;
        this.retryTransactionUseCaseProvider = retryTransactionUseCaseProvider;
        this.appControlProvider = appControlProvider;
        this.appUpdateRepositoryProvider = appUpdateRepositoryProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.balanceRepositoryProvider = balanceRepositoryProvider;
        this.statisticsRepositoryProvider = statisticsRepositoryProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.socketServiceProvider = socketServiceProvider;
        this.accessibilityRepositoryProvider = accessibilityRepositoryProvider;
        this.accountHealthRepositoryProvider = accountHealthRepositoryProvider;
        this.tokenRepositoryProvider = tokenRepositoryProvider;
        this.tokenRefreshServiceProvider = tokenRefreshServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HomeViewModel get() {
        return newInstance(this.contextProvider.get(), this.authRepositoryProvider.get(), this.subscriptionRepositoryProvider.get(), this.getCommissionForDatesUseCaseProvider.get(), this.logoutUserUseCaseProvider.get(), this.retryTransactionUseCaseProvider.get(), this.appControlProvider.get(), this.appUpdateRepositoryProvider.get(), this.transactionRepositoryProvider.get(), this.balanceRepositoryProvider.get(), this.statisticsRepositoryProvider.get(), this.settingsRepositoryProvider.get(), this.socketServiceProvider.get(), this.accessibilityRepositoryProvider.get(), this.accountHealthRepositoryProvider.get(), this.tokenRepositoryProvider.get(), this.tokenRefreshServiceProvider.get());
    }

    public static HomeViewModel_Factory create(Provider<Context> contextProvider, Provider<AuthRepository> authRepositoryProvider, Provider<SubscriptionRepository> subscriptionRepositoryProvider, Provider<GetCommissionForDatesUseCase> getCommissionForDatesUseCaseProvider, Provider<LogoutUserUseCase> logoutUserUseCaseProvider, Provider<RetryTransactionUseCase> retryTransactionUseCaseProvider, Provider<AppControl> appControlProvider, Provider<AppUpdateRepository> appUpdateRepositoryProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<BalanceRepository> balanceRepositoryProvider, Provider<StatisticsRepository> statisticsRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<SocketService> socketServiceProvider, Provider<AccessibilityRepository> accessibilityRepositoryProvider, Provider<AccountHealthRepository> accountHealthRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider, Provider<TokenRefreshService> tokenRefreshServiceProvider) {
        return new HomeViewModel_Factory(contextProvider, authRepositoryProvider, subscriptionRepositoryProvider, getCommissionForDatesUseCaseProvider, logoutUserUseCaseProvider, retryTransactionUseCaseProvider, appControlProvider, appUpdateRepositoryProvider, transactionRepositoryProvider, balanceRepositoryProvider, statisticsRepositoryProvider, settingsRepositoryProvider, socketServiceProvider, accessibilityRepositoryProvider, accountHealthRepositoryProvider, tokenRepositoryProvider, tokenRefreshServiceProvider);
    }

    public static HomeViewModel newInstance(Context context, AuthRepository authRepository, SubscriptionRepository subscriptionRepository, GetCommissionForDatesUseCase getCommissionForDatesUseCase, LogoutUserUseCase logoutUserUseCase, RetryTransactionUseCase retryTransactionUseCase, AppControl appControl, AppUpdateRepository appUpdateRepository, TransactionRepository transactionRepository, BalanceRepository balanceRepository, StatisticsRepository statisticsRepository, SettingsRepository settingsRepository, SocketService socketService, AccessibilityRepository accessibilityRepository, AccountHealthRepository accountHealthRepository, TokenRepository tokenRepository, TokenRefreshService tokenRefreshService) {
        return new HomeViewModel(context, authRepository, subscriptionRepository, getCommissionForDatesUseCase, logoutUserUseCase, retryTransactionUseCase, appControl, appUpdateRepository, transactionRepository, balanceRepository, statisticsRepository, settingsRepository, socketService, accessibilityRepository, accountHealthRepository, tokenRepository, tokenRefreshService);
    }
}
