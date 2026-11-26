package com.example.bingwahybrid.presentation.hybridconnect.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes3.dex */
public final class HybridConnectViewModel_HiltModules {
    private HybridConnectViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(HybridConnectViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(HybridConnectViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(HybridConnectViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
