package lc;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class l<T> implements f<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xc.a<? extends T> f12706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f12707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12708c;

    public l(xc.a<? extends T> initializer, Object obj) {
        kotlin.jvm.internal.k.e(initializer, "initializer");
        this.f12706a = initializer;
        this.f12707b = o.f12710a;
        this.f12708c = obj == null ? this : obj;
    }

    public /* synthetic */ l(xc.a aVar, Object obj, int i10, kotlin.jvm.internal.g gVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }

    public boolean a() {
        return this.f12707b != o.f12710a;
    }

    @Override // lc.f
    public T getValue() {
        T tInvoke;
        T t10 = (T) this.f12707b;
        o oVar = o.f12710a;
        if (t10 != oVar) {
            return t10;
        }
        synchronized (this.f12708c) {
            tInvoke = (T) this.f12707b;
            if (tInvoke == oVar) {
                xc.a<? extends T> aVar = this.f12706a;
                kotlin.jvm.internal.k.b(aVar);
                tInvoke = aVar.invoke();
                this.f12707b = tInvoke;
                this.f12706a = null;
            }
        }
        return tInvoke;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
