package com.example.bingwahybrid.domain.security;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: TokenRefreshService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/security/TokenRefreshService;", "", "refreshAccessToken", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface TokenRefreshService {
    Object refreshAccessToken(Continuation<? super Boolean> continuation);
}
