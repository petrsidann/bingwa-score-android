package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class TransactionStatusClassifier_Factory implements Factory<TransactionStatusClassifier> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TransactionStatusClassifier get() {
        return newInstance();
    }

    public static TransactionStatusClassifier_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TransactionStatusClassifier newInstance() {
        return new TransactionStatusClassifier();
    }

    private static final class InstanceHolder {
        static final TransactionStatusClassifier_Factory INSTANCE = new TransactionStatusClassifier_Factory();

        private InstanceHolder() {
        }
    }
}
