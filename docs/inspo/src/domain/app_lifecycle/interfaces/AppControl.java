package com.example.bingwahybrid.domain.app_lifecycle.interfaces;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: AppControl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;", "Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppStateProvider;", "startApp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pauseApp", "resumeApp", "stopApp", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AppControl extends AppStateProvider {
    Object pauseApp(Continuation<? super Unit> continuation);

    Object resumeApp(Continuation<? super Unit> continuation);

    Object startApp(Continuation<? super Unit> continuation);

    Object stopApp(Continuation<? super Unit> continuation);
}
