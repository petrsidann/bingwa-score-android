package com.example.bingwahybrid.domain.engine.pipeline;

import com.example.bingwahybrid.domain.engine.pipeline.handlers.BranchingHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.PreDialHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.TransactionStatusClassifier;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.UssdDialingHandler;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class TransactionPipeline_Factory implements Factory<TransactionPipeline> {
    private final Provider<BranchingHandler> branchingHandlerProvider;
    private final Provider<PreDialHandler> preDialHandlerProvider;
    private final Provider<TransactionStatusClassifier> transactionStatusClassifierProvider;
    private final Provider<UssdDialingHandler> ussdDialingHandlerProvider;

    private TransactionPipeline_Factory(Provider<PreDialHandler> preDialHandlerProvider, Provider<UssdDialingHandler> ussdDialingHandlerProvider, Provider<TransactionStatusClassifier> transactionStatusClassifierProvider, Provider<BranchingHandler> branchingHandlerProvider) {
        this.preDialHandlerProvider = preDialHandlerProvider;
        this.ussdDialingHandlerProvider = ussdDialingHandlerProvider;
        this.transactionStatusClassifierProvider = transactionStatusClassifierProvider;
        this.branchingHandlerProvider = branchingHandlerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TransactionPipeline get() {
        return newInstance(this.preDialHandlerProvider.get(), this.ussdDialingHandlerProvider.get(), this.transactionStatusClassifierProvider.get(), this.branchingHandlerProvider.get());
    }

    public static TransactionPipeline_Factory create(Provider<PreDialHandler> preDialHandlerProvider, Provider<UssdDialingHandler> ussdDialingHandlerProvider, Provider<TransactionStatusClassifier> transactionStatusClassifierProvider, Provider<BranchingHandler> branchingHandlerProvider) {
        return new TransactionPipeline_Factory(preDialHandlerProvider, ussdDialingHandlerProvider, transactionStatusClassifierProvider, branchingHandlerProvider);
    }

    public static TransactionPipeline newInstance(PreDialHandler preDialHandler, UssdDialingHandler ussdDialingHandler, TransactionStatusClassifier transactionStatusClassifier, BranchingHandler branchingHandler) {
        return new TransactionPipeline(preDialHandler, ussdDialingHandler, transactionStatusClassifier, branchingHandler);
    }
}
