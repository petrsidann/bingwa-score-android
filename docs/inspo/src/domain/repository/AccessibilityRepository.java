package com.example.bingwahybrid.domain.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AccessibilityRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0011\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0014\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\n¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/AccessibilityRepository;", "", "isAccessibilityServiceEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "openAccessibilitySettingsFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "", "getOpenAccessibilitySettingsFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "accessibilityServiceConnectedFlow", "getAccessibilityServiceConnectedFlow", "accessibilityStatusFlow", "getAccessibilityStatusFlow", "accessibilityStatusRequestFlow", "getAccessibilityStatusRequestFlow", "requestOpenAccessibilitySettings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyAccessibilityServiceConnected", "requestAccessibilityStatus", "postAccessibilityServiceStatus", "isActive", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AccessibilityRepository {
    SharedFlow<Unit> getAccessibilityServiceConnectedFlow();

    SharedFlow<Boolean> getAccessibilityStatusFlow();

    SharedFlow<Unit> getAccessibilityStatusRequestFlow();

    SharedFlow<Unit> getOpenAccessibilitySettingsFlow();

    StateFlow<Boolean> isAccessibilityServiceEnabled();

    Object notifyAccessibilityServiceConnected(Continuation<? super Unit> continuation);

    Object postAccessibilityServiceStatus(boolean z, Continuation<? super Unit> continuation);

    Object requestAccessibilityStatus(Continuation<? super Unit> continuation);

    Object requestOpenAccessibilitySettings(Continuation<? super Unit> continuation);
}
