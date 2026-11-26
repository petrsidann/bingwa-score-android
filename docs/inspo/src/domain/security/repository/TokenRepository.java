package com.example.bingwahybrid.domain.security.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: TokenRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\tJ\u000e\u0010\u000b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\tJ\u000e\u0010\f\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\t¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;", "", "saveAccessToken", "", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRefreshToken", "getAccessToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRefreshToken", "validateAccessToken", "clearAll", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface TokenRepository {
    Object clearAll(Continuation<? super Unit> continuation);

    Object getAccessToken(Continuation<? super String> continuation);

    Object getRefreshToken(Continuation<? super String> continuation);

    Object saveAccessToken(String str, Continuation<? super Unit> continuation);

    Object saveRefreshToken(String str, Continuation<? super Unit> continuation);

    Object validateAccessToken(Continuation<? super Unit> continuation);
}
