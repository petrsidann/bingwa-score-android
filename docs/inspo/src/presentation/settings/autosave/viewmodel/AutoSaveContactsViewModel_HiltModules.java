package com.example.bingwahybrid.presentation.settings.autosave.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes3.dex */
public final class AutoSaveContactsViewModel_HiltModules {
    private AutoSaveContactsViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(AutoSaveContactsViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(AutoSaveContactsViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(AutoSaveContactsViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
