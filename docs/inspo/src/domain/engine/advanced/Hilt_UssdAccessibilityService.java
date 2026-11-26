package com.example.bingwahybrid.domain.engine.advanced;

import android.accessibilityservice.AccessibilityService;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Hilt_UssdAccessibilityService extends AccessibilityService implements GeneratedComponentManagerHolder {
    private volatile ServiceComponentManager componentManager;
    private final Object componentManagerLock = new Object();
    private boolean injected = false;

    @Override // android.app.Service
    public void onCreate() {
        inject();
        super.onCreate();
    }

    protected ServiceComponentManager createComponentManager() {
        return new ServiceComponentManager(this);
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final ServiceComponentManager componentManager() {
        if (this.componentManager == null) {
            synchronized (this.componentManagerLock) {
                if (this.componentManager == null) {
                    this.componentManager = createComponentManager();
                }
            }
        }
        return this.componentManager;
    }

    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((UssdAccessibilityService_GeneratedInjector) generatedComponent()).injectUssdAccessibilityService((UssdAccessibilityService) UnsafeCasts.unsafeCast(this));
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }
}
