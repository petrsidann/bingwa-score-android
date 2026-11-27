package dd;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.k;
import lc.q;
import oc.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends d<T> implements Iterator<T>, oc.e<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f6710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator<? extends T> f6711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public oc.e<? super q> f6712d;

    @Override // dd.d
    public Object b(T t10, oc.e<? super q> eVar) {
        this.f6710b = t10;
        this.f6709a = 3;
        this.f6712d = eVar;
        Object objC = pc.c.c();
        if (objC == pc.c.c()) {
            qc.h.c(eVar);
        }
        return objC == pc.c.c() ? objC : q.f12711a;
    }

    public final Throwable d() {
        int i10 = this.f6709a;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f6709a);
    }

    public final T e() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void f(oc.e<? super q> eVar) {
        this.f6712d = eVar;
    }

    @Override // oc.e
    public oc.i getContext() {
        return j.f13812a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i10 = this.f6709a;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw d();
                }
                Iterator<? extends T> it = this.f6711c;
                k.b(it);
                if (it.hasNext()) {
                    this.f6709a = 2;
                    return true;
                }
                this.f6711c = null;
            }
            this.f6709a = 5;
            oc.e<? super q> eVar = this.f6712d;
            k.b(eVar);
            this.f6712d = null;
            lc.j.a aVar = lc.j.f12703b;
            eVar.resumeWith(lc.j.b(q.f12711a));
        }
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i10 = this.f6709a;
        if (i10 == 0 || i10 == 1) {
            return e();
        }
        if (i10 == 2) {
            this.f6709a = 1;
            Iterator<? extends T> it = this.f6711c;
            k.b(it);
            return it.next();
        }
        if (i10 != 3) {
            throw d();
        }
        this.f6709a = 0;
        T t10 = this.f6710b;
        this.f6710b = null;
        return t10;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // oc.e
    public void resumeWith(Object obj) throws Throwable {
        lc.k.b(obj);
        this.f6709a = 4;
    }
}
