package ld;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import ld.o0;

/* JADX INFO: loaded from: classes2.dex */
public class n0<T extends o0 & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12746b = AtomicIntegerFieldUpdater.newUpdater(n0.class, "_size");
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T[] f12747a;

    public final void a(T t10) {
        t10.k(this);
        o0[] o0VarArrF = f();
        int iC = c();
        j(iC + 1);
        o0VarArrF[iC] = t10;
        t10.setIndex(iC);
        l(iC);
    }

    public final T b() {
        T[] tArr = this.f12747a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return f12746b.get(this);
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T t10;
        synchronized (this) {
            t10 = (T) b();
        }
        return t10;
    }

    public final T[] f() {
        T[] tArr = this.f12747a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new o0[4];
            this.f12747a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, c() * 2);
        kotlin.jvm.internal.k.d(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((o0[]) objArrCopyOf);
        this.f12747a = tArr3;
        return tArr3;
    }

    public final boolean g(T t10) {
        boolean z10;
        synchronized (this) {
            if (t10.i() == null) {
                z10 = false;
            } else {
                h(t10.getIndex());
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003a  */
    public final T h(int i10) {
        T[] tArr = this.f12747a;
        kotlin.jvm.internal.k.b(tArr);
        j(c() - 1);
        if (i10 < c()) {
            m(i10, c());
            int i11 = (i10 - 1) / 2;
            if (i10 > 0) {
                T t10 = tArr[i10];
                kotlin.jvm.internal.k.b(t10);
                T t11 = tArr[i11];
                kotlin.jvm.internal.k.b(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    m(i10, i11);
                    l(i11);
                } else {
                    k(i10);
                }
            } else {
                k(i10);
            }
        }
        T t12 = tArr[c()];
        kotlin.jvm.internal.k.b(t12);
        t12.k(null);
        t12.setIndex(-1);
        tArr[c()] = null;
        return t12;
    }

    public final T i() {
        T t10;
        synchronized (this) {
            t10 = c() > 0 ? (T) h(0) : null;
        }
        return t10;
    }

    public final void j(int i10) {
        f12746b.set(this, i10);
    }

    public final void k(int i10) {
        while (true) {
            int i11 = (i10 * 2) + 1;
            if (i11 >= c()) {
                return;
            }
            T[] tArr = this.f12747a;
            kotlin.jvm.internal.k.b(tArr);
            int i12 = i11 + 1;
            if (i12 < c()) {
                T t10 = tArr[i12];
                kotlin.jvm.internal.k.b(t10);
                T t11 = tArr[i11];
                kotlin.jvm.internal.k.b(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    i11 = i12;
                }
            }
            T t12 = tArr[i10];
            kotlin.jvm.internal.k.b(t12);
            T t13 = tArr[i11];
            kotlin.jvm.internal.k.b(t13);
            if (((Comparable) t12).compareTo(t13) <= 0) {
                return;
            }
            m(i10, i11);
            i10 = i11;
        }
    }

    public final void l(int i10) {
        while (i10 > 0) {
            T[] tArr = this.f12747a;
            kotlin.jvm.internal.k.b(tArr);
            int i11 = (i10 - 1) / 2;
            T t10 = tArr[i11];
            kotlin.jvm.internal.k.b(t10);
            T t11 = tArr[i10];
            kotlin.jvm.internal.k.b(t11);
            if (((Comparable) t10).compareTo(t11) <= 0) {
                return;
            }
            m(i10, i11);
            i10 = i11;
        }
    }

    public final void m(int i10, int i11) {
        T[] tArr = this.f12747a;
        kotlin.jvm.internal.k.b(tArr);
        T t10 = tArr[i11];
        kotlin.jvm.internal.k.b(t10);
        T t11 = tArr[i10];
        kotlin.jvm.internal.k.b(t11);
        tArr[i10] = t10;
        tArr[i11] = t11;
        t10.setIndex(i10);
        t11.setIndex(i11);
    }
}
