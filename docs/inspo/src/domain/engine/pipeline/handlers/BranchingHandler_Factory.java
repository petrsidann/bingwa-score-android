package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.engine.pipeline.chains.AlreadyRecommendedChain;
import com.example.bingwahybrid.domain.engine.pipeline.chains.ExternalRetryChain;
import com.example.bingwahybrid.domain.engine.pipeline.chains.FailureChain;
import com.example.bingwahybrid.domain.engine.pipeline.chains.InternalRetryChain;
import com.example.bingwahybrid.domain.engine.pipeline.chains.SuccessChain;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class BranchingHandler_Factory implements Factory<BranchingHandler> {
    private final Provider<AlreadyRecommendedChain> alreadyRecommendedChainProvider;
    private final Provider<ExternalRetryChain> externalRetryChainProvider;
    private final Provider<FailureChain> failureChainProvider;
    private final Provider<InternalRetryChain> internalRetryChainProvider;
    private final Provider<SuccessChain> successChainProvider;

    private BranchingHandler_Factory(Provider<SuccessChain> successChainProvider, Provider<FailureChain> failureChainProvider, Provider<InternalRetryChain> internalRetryChainProvider, Provider<ExternalRetryChain> externalRetryChainProvider, Provider<AlreadyRecommendedChain> alreadyRecommendedChainProvider) {
        this.successChainProvider = successChainProvider;
        this.failureChainProvider = failureChainProvider;
        this.internalRetryChainProvider = internalRetryChainProvider;
        this.externalRetryChainProvider = externalRetryChainProvider;
        this.alreadyRecommendedChainProvider = alreadyRecommendedChainProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BranchingHandler get() {
        return newInstance(this.successChainProvider.get(), this.failureChainProvider.get(), this.internalRetryChainProvider.get(), this.externalRetryChainProvider.get(), this.alreadyRecommendedChainProvider.get());
    }

    public static BranchingHandler_Factory create(Provider<SuccessChain> successChainProvider, Provider<FailureChain> failureChainProvider, Provider<InternalRetryChain> internalRetryChainProvider, Provider<ExternalRetryChain> externalRetryChainProvider, Provider<AlreadyRecommendedChain> alreadyRecommendedChainProvider) {
        return new BranchingHandler_Factory(successChainProvider, failureChainProvider, internalRetryChainProvider, externalRetryChainProvider, alreadyRecommendedChainProvider);
    }

    public static BranchingHandler newInstance(SuccessChain successChain, FailureChain failureChain, InternalRetryChain internalRetryChain, ExternalRetryChain externalRetryChain, AlreadyRecommendedChain alreadyRecommendedChain) {
        return new BranchingHandler(successChain, failureChain, internalRetryChain, externalRetryChain, alreadyRecommendedChain);
    }
}
