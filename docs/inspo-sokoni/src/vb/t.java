package vb;

import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class t {
    public static l1 a(s sVar) {
        j6.m.p(sVar, "context must not be null");
        if (!sVar.h()) {
            return null;
        }
        Throwable thC = sVar.c();
        if (thC == null) {
            return l1.f17406f.q("io.grpc.Context was cancelled without error");
        }
        if (thC instanceof TimeoutException) {
            return l1.f17409i.q(thC.getMessage()).p(thC);
        }
        l1 l1VarK = l1.k(thC);
        return (l1.b.UNKNOWN.equals(l1VarK.m()) && l1VarK.l() == thC) ? l1.f17406f.q("Context cancelled").p(thC) : l1VarK.p(thC);
    }
}
