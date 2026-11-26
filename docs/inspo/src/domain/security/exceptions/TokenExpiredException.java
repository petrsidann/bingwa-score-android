package com.example.bingwahybrid.domain.security.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TokenExpiredException.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/example/bingwahybrid/domain/security/exceptions/TokenExpiredException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TokenExpiredException extends Exception {
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public TokenExpiredException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ TokenExpiredException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Session expired. You might need to connect to the internet" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TokenExpiredException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
