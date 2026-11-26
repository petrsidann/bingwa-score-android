package com.example.bingwahybrid.presentation.sitelink.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes3.dex */
public final class AddSiteLinkOfferViewModel_HiltModules {
    private AddSiteLinkOfferViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(AddSiteLinkOfferViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(AddSiteLinkOfferViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(AddSiteLinkOfferViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
