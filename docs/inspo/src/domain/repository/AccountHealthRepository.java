package com.example.bingwahybrid.domain.repository;

import com.example.bingwahybrid.domain.enums.AccountHealthStatus;
import com.example.bingwahybrid.domain.model.AccountHealth;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AccountHealthRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fH¦@¢\u0006\u0002\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/AccountHealthRepository;", "", "accountHealthStatus", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bingwahybrid/domain/enums/AccountHealthStatus;", "getAccountHealthStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "saveAccountHealth", "", "health", "Lcom/example/bingwahybrid/domain/model/AccountHealth;", "(Lcom/example/bingwahybrid/domain/model/AccountHealth;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastKnownHealth", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastKnownServerTime", "", "isDeviceBackdated", "", "serverTime", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AccountHealthRepository {
    StateFlow<AccountHealthStatus> getAccountHealthStatus();

    Object getLastKnownHealth(Continuation<? super AccountHealth> continuation);

    Object getLastKnownServerTime(Continuation<? super Long> continuation);

    boolean isDeviceBackdated(long serverTime);

    Object saveAccountHealth(AccountHealth accountHealth, Continuation<? super Unit> continuation);
}
