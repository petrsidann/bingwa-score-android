package com.example.bingwahybrid.domain.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: NavigationManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\fR\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/utils/NavigationManager;", "", "<init>", "()V", "_navigationEvent", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/domain/utils/NavigationEvent;", "navigationEvent", "Lkotlinx/coroutines/flow/StateFlow;", "getNavigationEvent", "()Lkotlinx/coroutines/flow/StateFlow;", "to", "", "route", "", "back", "resetNavigationEvent", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationManager {
    public static final int $stable;
    public static final NavigationManager INSTANCE = new NavigationManager();
    private static final MutableStateFlow<NavigationEvent> _navigationEvent;
    private static final StateFlow<NavigationEvent> navigationEvent;

    private NavigationManager() {
    }

    static {
        MutableStateFlow<NavigationEvent> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        _navigationEvent = MutableStateFlow;
        navigationEvent = MutableStateFlow;
        $stable = 8;
    }

    public final StateFlow<NavigationEvent> getNavigationEvent() {
        return navigationEvent;
    }

    public final void to(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        _navigationEvent.setValue(new NavigationEvent.To(route));
    }

    public final void back() {
        _navigationEvent.setValue(NavigationEvent.Back.INSTANCE);
    }

    public final void resetNavigationEvent() {
        _navigationEvent.setValue(null);
    }
}
