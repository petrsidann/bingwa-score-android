package com.example.bingwahybrid.domain.engine;

import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.engine.pipeline.TransactionPipeline;
import com.example.bingwahybrid.domain.engine.pipeline.chains.FailureChain;
import com.example.bingwahybrid.domain.engine.pipeline.chains.TimeoutChain;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class UssdDialerService_MembersInjector implements MembersInjector<UssdDialerService> {
    private final Provider<AppControl> appControlProvider;
    private final Provider<FailureChain> failureChainProvider;
    private final Provider<TimeoutChain> timeoutChainProvider;
    private final Provider<TransactionPipeline> transactionPipelineProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private UssdDialerService_MembersInjector(Provider<TransactionRepository> transactionRepositoryProvider, Provider<AppControl> appControlProvider, Provider<TransactionPipeline> transactionPipelineProvider, Provider<FailureChain> failureChainProvider, Provider<TimeoutChain> timeoutChainProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.appControlProvider = appControlProvider;
        this.transactionPipelineProvider = transactionPipelineProvider;
        this.failureChainProvider = failureChainProvider;
        this.timeoutChainProvider = timeoutChainProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(UssdDialerService instance) {
        injectTransactionRepository(instance, this.transactionRepositoryProvider.get());
        injectAppControl(instance, this.appControlProvider.get());
        injectTransactionPipeline(instance, this.transactionPipelineProvider.get());
        injectFailureChain(instance, this.failureChainProvider.get());
        injectTimeoutChain(instance, this.timeoutChainProvider.get());
    }

    public static MembersInjector<UssdDialerService> create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<AppControl> appControlProvider, Provider<TransactionPipeline> transactionPipelineProvider, Provider<FailureChain> failureChainProvider, Provider<TimeoutChain> timeoutChainProvider) {
        return new UssdDialerService_MembersInjector(transactionRepositoryProvider, appControlProvider, transactionPipelineProvider, failureChainProvider, timeoutChainProvider);
    }

    public static void injectTransactionRepository(UssdDialerService instance, TransactionRepository transactionRepository) {
        instance.transactionRepository = transactionRepository;
    }

    public static void injectAppControl(UssdDialerService instance, AppControl appControl) {
        instance.appControl = appControl;
    }

    public static void injectTransactionPipeline(UssdDialerService instance, TransactionPipeline transactionPipeline) {
        instance.transactionPipeline = transactionPipeline;
    }

    public static void injectFailureChain(UssdDialerService instance, FailureChain failureChain) {
        instance.failureChain = failureChain;
    }

    public static void injectTimeoutChain(UssdDialerService instance, TimeoutChain timeoutChain) {
        instance.timeoutChain = timeoutChain;
    }
}
