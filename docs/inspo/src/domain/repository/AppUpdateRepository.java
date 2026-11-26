package com.example.bingwahybrid.domain.repository;

import com.example.bingwahybrid.domain.updates.enums.UpdateState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AppUpdateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/AppUpdateRepository;", "", "updateState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;", "getUpdateState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkForUpdates", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadAndInstall", "apkUrl", "", "hideInstallDialog", "time", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AppUpdateRepository {
    Object checkForUpdates(Continuation<? super Unit> continuation);

    void downloadAndInstall(String apkUrl);

    StateFlow<UpdateState> getUpdateState();

    void hideInstallDialog(long time);
}
