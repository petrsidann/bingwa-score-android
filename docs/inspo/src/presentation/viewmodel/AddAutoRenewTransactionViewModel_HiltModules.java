package com.example.bingwahybrid.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes3.dex */
public final class AddAutoRenewTransactionViewModel_HiltModules {
    private AddAutoRenewTransactionViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(AddAutoRenewTransactionViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(AddAutoRenewTransactionViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(AddAutoRenewTransactionViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
