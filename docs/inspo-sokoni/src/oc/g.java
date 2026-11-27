package oc;

import kotlin.jvm.internal.k;
import lc.q;
import xc.p;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final <R, T> void a(p<? super R, ? super e<? super T>, ? extends Object> pVar, R r10, e<? super T> completion) {
        k.e(pVar, "<this>");
        k.e(completion, "completion");
        e eVarB = pc.b.b(pc.b.a(pVar, r10, completion));
        lc.j.a aVar = lc.j.f12703b;
        eVarB.resumeWith(lc.j.b(q.f12711a));
    }
}
