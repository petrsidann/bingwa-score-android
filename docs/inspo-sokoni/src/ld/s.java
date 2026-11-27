package ld;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12761a = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12762b = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12763c = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    public static abstract class a extends ld.b<s> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s f12764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s f12765c;

        public a(s sVar) {
            this.f12764b = sVar;
        }

        @Override // ld.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(s sVar, Object obj) {
            boolean z10 = obj == null;
            s sVar2 = z10 ? this.f12764b : this.f12765c;
            if (sVar2 != null && u.b.a(s.f12761a, sVar, this, sVar2) && z10) {
                s sVar3 = this.f12764b;
                s sVar4 = this.f12765c;
                kotlin.jvm.internal.k.b(sVar4);
                sVar3.k(sVar4);
            }
        }
    }

    public final boolean g(s sVar) {
        f12762b.lazySet(sVar, this);
        f12761a.lazySet(sVar, this);
        while (l() == this) {
            if (u.b.a(f12761a, this, this, sVar)) {
                sVar.k(this);
                return true;
            }
        }
        return false;
    }

    public final s i(a0 a0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        while (true) {
            s sVar = (s) f12762b.get(this);
            s sVar2 = sVar;
            while (true) {
                s sVar3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = f12761a;
                    obj = atomicReferenceFieldUpdater.get(sVar2);
                    if (obj == this) {
                        if (sVar != sVar2 && !u.b.a(f12762b, this, sVar, sVar2)) {
                            break;
                        }
                        return sVar2;
                    }
                    if (o()) {
                        return null;
                    }
                    if (obj == a0Var) {
                        return sVar2;
                    }
                    if (obj instanceof a0) {
                        ((a0) obj).a(sVar2);
                        break;
                    }
                    if (!(obj instanceof b0)) {
                        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                        sVar3 = sVar2;
                        sVar2 = (s) obj;
                    } else {
                        if (sVar3 != null) {
                            break;
                        }
                        sVar2 = (s) f12762b.get(sVar2);
                    }
                }
                if (!u.b.a(atomicReferenceFieldUpdater, sVar3, sVar2, ((b0) obj).f12714a)) {
                    break;
                }
                sVar2 = sVar3;
            }
        }
    }

    public final s j(s sVar) {
        while (sVar.o()) {
            sVar = (s) f12762b.get(sVar);
        }
        return sVar;
    }

    public final void k(s sVar) {
        s sVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12762b;
        do {
            sVar2 = (s) atomicReferenceFieldUpdater.get(sVar);
            if (l() != sVar) {
                return;
            }
        } while (!u.b.a(f12762b, sVar, sVar2, this));
        if (o()) {
            sVar.i(null);
        }
    }

    public final Object l() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12761a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof a0)) {
                return obj;
            }
            ((a0) obj).a(this);
        }
    }

    public final s m() {
        return r.b(l());
    }

    public final s n() {
        s sVarI = i(null);
        return sVarI == null ? j((s) f12762b.get(this)) : sVarI;
    }

    public boolean o() {
        return l() instanceof b0;
    }

    public boolean p() {
        return q() == null;
    }

    public final s q() {
        Object objL;
        s sVar;
        do {
            objL = l();
            if (objL instanceof b0) {
                return ((b0) objL).f12714a;
            }
            if (objL == this) {
                return (s) objL;
            }
            kotlin.jvm.internal.k.c(objL, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            sVar = (s) objL;
        } while (!u.b.a(f12761a, this, objL, sVar.r()));
        sVar.i(null);
        return null;
    }

    public final b0 r() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12763c;
        b0 b0Var = (b0) atomicReferenceFieldUpdater.get(this);
        if (b0Var != null) {
            return b0Var;
        }
        b0 b0Var2 = new b0(this);
        atomicReferenceFieldUpdater.lazySet(this, b0Var2);
        return b0Var2;
    }

    public final int s(s sVar, s sVar2, a aVar) {
        f12762b.lazySet(sVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12761a;
        atomicReferenceFieldUpdater.lazySet(sVar, sVar2);
        aVar.f12765c = sVar2;
        if (u.b.a(atomicReferenceFieldUpdater, this, sVar2, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return new kotlin.jvm.internal.o(this) { // from class: ld.s.b
            @Override // cd.g
            public Object get() {
                return gd.q0.a(this.receiver);
            }
        } + '@' + gd.q0.b(this);
    }
}
