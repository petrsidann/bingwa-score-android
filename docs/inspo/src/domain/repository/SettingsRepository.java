package com.example.bingwahybrid.domain.repository;

import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.enums.ProcessingMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: SettingsRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "", "processingMode", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bingwahybrid/domain/enums/ProcessingMode;", "getProcessingMode", "()Lkotlinx/coroutines/flow/StateFlow;", "hybridPortalActive", "", "getHybridPortalActive", "saveSetting", "", "setting", "Lcom/example/bingwahybrid/domain/enums/AppSetting;", "value", "", "(Lcom/example/bingwahybrid/domain/enums/AppSetting;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSetting", "(Lcom/example/bingwahybrid/domain/enums/AppSetting;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOnBoardingCompleted", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOnBoardingCompleted", "setProcessingMode", "(Lcom/example/bingwahybrid/domain/enums/ProcessingMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SettingsRepository {
    StateFlow<Boolean> getHybridPortalActive();

    Object getProcessingMode(Continuation<? super ProcessingMode> continuation);

    StateFlow<ProcessingMode> getProcessingMode();

    Object getSetting(AppSetting appSetting, Continuation<? super String> continuation);

    Object isOnBoardingCompleted(Continuation<? super Boolean> continuation);

    Object saveSetting(AppSetting appSetting, String str, Continuation<? super Unit> continuation);

    Object setOnBoardingCompleted(Continuation<? super Unit> continuation);

    Object setProcessingMode(ProcessingMode processingMode, Continuation<? super Unit> continuation);
}
