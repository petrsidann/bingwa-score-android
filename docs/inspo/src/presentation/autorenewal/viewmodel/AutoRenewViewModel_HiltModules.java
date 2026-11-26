package com.example.bingwahybrid.presentation.autorenewal.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes3.dex */
public final class AutoRenewViewModel_HiltModules {
    private AutoRenewViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(AutoRenewViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(AutoRenewViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(AutoRenewViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
