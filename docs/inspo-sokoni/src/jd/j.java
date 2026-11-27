package jd;

import gd.y1;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j {
    public static final void a(oc.i iVar) {
        if (iVar.get(y1.f9273i) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + iVar).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> d<T> b(d<? extends T> dVar, oc.i iVar) {
        a(iVar);
        if (kotlin.jvm.internal.k.a(iVar, oc.j.f13812a)) {
            return dVar;
        }
        return dVar instanceof kd.k ? kd.k.a.a((kd.k) dVar, iVar, 0, null, 6, null) : new kd.h(dVar, iVar, 0, null, 12, null);
    }
}
