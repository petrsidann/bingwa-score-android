package oc;

import java.io.Serializable;
import kotlin.jvm.internal.k;
import xc.p;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f13808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i.b f13809b;

    public d(i left, i.b element) {
        k.e(left, "left");
        k.e(element, "element");
        this.f13808a = left;
        this.f13809b = element;
    }

    public static final String e(String acc, i.b element) {
        k.e(acc, "acc");
        k.e(element, "element");
        if (acc.length() == 0) {
            return element.toString();
        }
        return acc + ", " + element;
    }

    public final boolean b(i.b bVar) {
        return k.a(get(bVar.getKey()), bVar);
    }

    public final boolean c(d dVar) {
        while (b(dVar.f13809b)) {
            i iVar = dVar.f13808a;
            if (!(iVar instanceof d)) {
                k.c(iVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return b((i.b) iVar);
            }
            dVar = (d) iVar;
        }
        return false;
    }

    public final int d() {
        int i10 = 2;
        d dVar = this;
        while (true) {
            i iVar = dVar.f13808a;
            dVar = iVar instanceof d ? (d) iVar : null;
            if (dVar == null) {
                return i10;
            }
            i10++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (dVar.d() != d() || !dVar.c(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // oc.i
    public <R> R fold(R r10, p<? super R, ? super i.b, ? extends R> operation) {
        k.e(operation, "operation");
        return operation.invoke((Object) this.f13808a.fold(r10, operation), this.f13809b);
    }

    @Override // oc.i
    public <E extends i.b> E get(i.c<E> key) {
        k.e(key, "key");
        d dVar = this;
        while (true) {
            E e10 = (E) dVar.f13809b.get(key);
            if (e10 != null) {
                return e10;
            }
            i iVar = dVar.f13808a;
            if (!(iVar instanceof d)) {
                return (E) iVar.get(key);
            }
            dVar = (d) iVar;
        }
    }

    public int hashCode() {
        return this.f13808a.hashCode() + this.f13809b.hashCode();
    }

    @Override // oc.i
    public i minusKey(i.c<?> key) {
        k.e(key, "key");
        if (this.f13809b.get(key) != null) {
            return this.f13808a;
        }
        i iVarMinusKey = this.f13808a.minusKey(key);
        if (iVarMinusKey == this.f13808a) {
            return this;
        }
        return iVarMinusKey == j.f13812a ? this.f13809b : new d(iVarMinusKey, this.f13809b);
    }

    @Override // oc.i
    public i plus(i iVar) {
        return i.a.b(this, iVar);
    }

    public String toString() {
        return '[' + ((String) fold("", new p() { // from class: oc.c
            @Override // xc.p
            public final Object invoke(Object obj, Object obj2) {
                return d.e((String) obj, (i.b) obj2);
            }
        })) + ']';
    }
}
