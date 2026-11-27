package qc;

import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l extends d implements kotlin.jvm.internal.h<Object> {
    private final int arity;

    public l(int i10) {
        this(i10, null);
    }

    public l(int i10, oc.e<Object> eVar) {
        super(eVar);
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
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
