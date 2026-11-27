package oc;

import java.io.Serializable;
import kotlin.jvm.internal.k;
import xc.p;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f13812a = new j();

    @Override // oc.i
    public <R> R fold(R r10, p<? super R, ? super i.b, ? extends R> operation) {
        k.e(operation, "operation");
        return r10;
    }

    @Override // oc.i
    public <E extends i.b> E get(i.c<E> key) {
        k.e(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // oc.i
    public i minusKey(i.c<?> key) {
        k.e(key, "key");
        return this;
    }

    @Override // oc.i
    public i plus(i context) {
        k.e(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
