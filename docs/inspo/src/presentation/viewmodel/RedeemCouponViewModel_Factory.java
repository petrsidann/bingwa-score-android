package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class RedeemCouponViewModel_Factory implements Factory<RedeemCouponViewModel> {
    private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

    private RedeemCouponViewModel_Factory(Provider<SubscriptionRepository> subscriptionRepositoryProvider) {
        this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RedeemCouponViewModel get() {
        return newInstance(this.subscriptionRepositoryProvider.get());
    }

    public static RedeemCouponViewModel_Factory create(Provider<SubscriptionRepository> subscriptionRepositoryProvider) {
        return new RedeemCouponViewModel_Factory(subscriptionRepositoryProvider);
    }

    public static RedeemCouponViewModel newInstance(SubscriptionRepository subscriptionRepository) {
        return new RedeemCouponViewModel(subscriptionRepository);
    }
}
