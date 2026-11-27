package oc;

import kotlin.jvm.internal.k;
import oc.i.b;
import xc.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<B extends i.b, E extends B> implements i.c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l<i.b, E> f13806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i.c<?> f13807b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [oc.i$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, xc.l<? super oc.i$b, ? extends E extends B>, xc.l<oc.i$b, E extends B>] */
    public b(i.c<B> baseKey, l<? super i.b, ? extends E> safeCast) {
        k.e(baseKey, "baseKey");
        k.e(safeCast, "safeCast");
        this.f13806a = safeCast;
        this.f13807b = baseKey instanceof b ? (i.c<B>) ((b) baseKey).f13807b : baseKey;
    }

    public final boolean a(i.c<?> key) {
        k.e(key, "key");
        return key == this || this.f13807b == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Loc/i$b;)TE; */
    public final i.b b(i.b element) {
        k.e(element, "element");
        return (i.b) this.f13806a.invoke(element);
    }
}
