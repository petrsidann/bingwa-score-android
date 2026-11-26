package com.example.bingwahybrid.presentation.subscriptions.viewmodels;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriptionPaymentViewModel_HiltModules {
    private SubscriptionPaymentViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(SubscriptionPaymentViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(SubscriptionPaymentViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(SubscriptionPaymentViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
