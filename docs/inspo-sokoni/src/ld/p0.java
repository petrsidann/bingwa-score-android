package ld;

import gd.v2;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.i f12756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f12757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v2<Object>[] f12758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12759d;

    public p0(oc.i iVar, int i10) {
        this.f12756a = iVar;
        this.f12757b = new Object[i10];
        this.f12758c = new v2[i10];
    }

    public final void a(v2<?> v2Var, Object obj) {
        Object[] objArr = this.f12757b;
        int i10 = this.f12759d;
        objArr[i10] = obj;
        v2<Object>[] v2VarArr = this.f12758c;
        this.f12759d = i10 + 1;
        kotlin.jvm.internal.k.c(v2Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        v2VarArr[i10] = v2Var;
    }

    public final void b(oc.i iVar) {
        int length = this.f12758c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            v2<Object> v2Var = this.f12758c[length];
            kotlin.jvm.internal.k.b(v2Var);
            v2Var.O(iVar, this.f12757b[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }
}
