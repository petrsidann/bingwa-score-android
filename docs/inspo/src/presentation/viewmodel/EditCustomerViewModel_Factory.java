package com.example.bingwahybrid.presentation.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class EditCustomerViewModel_Factory implements Factory<EditCustomerViewModel> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public EditCustomerViewModel get() {
        return newInstance();
    }

    public static EditCustomerViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static EditCustomerViewModel newInstance() {
        return new EditCustomerViewModel();
    }

    private static final class InstanceHolder {
        static final EditCustomerViewModel_Factory INSTANCE = new EditCustomerViewModel_Factory();

        private InstanceHolder() {
        }
    }
}
