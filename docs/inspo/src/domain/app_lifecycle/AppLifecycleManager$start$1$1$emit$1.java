package com.example.bingwahybrid.domain.app_lifecycle;

import com.example.bingwahybrid.domain.enums.AppState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AppLifecycleManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.domain.app_lifecycle.AppLifecycleManager$start$1$1", f = "AppLifecycleManager.kt", i = {0, 1}, l = {40, 41}, m = "emit", n = {"appState", "appState"}, s = {"L$0", "L$0"})
final class AppLifecycleManager$start$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppLifecycleManager.AnonymousClass1.C01261<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AppLifecycleManager$start$1$1$emit$1(AppLifecycleManager.AnonymousClass1.C01261<? super T> c01261, Continuation<? super AppLifecycleManager$start$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c01261;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((AppState) null, (Continuation<? super Unit>) this);
    }
}
