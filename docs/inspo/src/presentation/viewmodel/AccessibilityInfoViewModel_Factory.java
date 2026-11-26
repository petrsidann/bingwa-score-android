package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.repository.AccessibilityRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AccessibilityInfoViewModel_Factory implements Factory<AccessibilityInfoViewModel> {
    private final Provider<AccessibilityRepository> accessibilityRepositoryProvider;

    private AccessibilityInfoViewModel_Factory(Provider<AccessibilityRepository> accessibilityRepositoryProvider) {
        this.accessibilityRepositoryProvider = accessibilityRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AccessibilityInfoViewModel get() {
        return newInstance(this.accessibilityRepositoryProvider.get());
    }

    public static AccessibilityInfoViewModel_Factory create(Provider<AccessibilityRepository> accessibilityRepositoryProvider) {
        return new AccessibilityInfoViewModel_Factory(accessibilityRepositoryProvider);
    }

    public static AccessibilityInfoViewModel newInstance(AccessibilityRepository accessibilityRepository) {
        return new AccessibilityInfoViewModel(accessibilityRepository);
    }
}
