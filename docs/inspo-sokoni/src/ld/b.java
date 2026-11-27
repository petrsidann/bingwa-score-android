package ld;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12713a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    private volatile Object _consensus = a.f12712a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ld.a0
    public final Object a(Object obj) {
        Object objC = f12713a.get(this);
        if (objC == a.f12712a) {
            objC = c(d(obj));
        }
        b(obj, objC);
        return objC;
    }

    public abstract void b(T t10, Object obj);

    public final Object c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12713a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = a.f12712a;
        if (obj2 != obj3) {
            return obj2;
        }
        return u.b.a(atomicReferenceFieldUpdater, this, obj3, obj) ? obj : atomicReferenceFieldUpdater.get(this);
    }

    public abstract Object d(T t10);
}
