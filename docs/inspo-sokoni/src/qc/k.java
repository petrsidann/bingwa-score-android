package qc;

import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends j implements kotlin.jvm.internal.h<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14935a;

    public k(int i10, oc.e<Object> eVar) {
        super(eVar);
        this.f14935a = i10;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.f14935a;
    }

    @Override // qc.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strF = u.f(this);
        kotlin.jvm.internal.k.d(strF, "renderLambdaToString(...)");
        return strF;
    }
}
