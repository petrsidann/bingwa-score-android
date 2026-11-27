package gd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f9153b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t0<T>[] f9154a;
    private volatile int notCompletedCount;

    public final class a extends f2 {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f9155m = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");
        private volatile Object _disposer;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final o<List<? extends T>> f9156e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e1 f9157f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(o<? super List<? extends T>> oVar) {
            this.f9156e = oVar;
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
            t(th);
            return lc.q.f12711a;
        }

        @Override // gd.e0
        public void t(Throwable th) {
            if (th != null) {
                Object objH = this.f9156e.h(th);
                if (objH != null) {
                    this.f9156e.n(objH);
                    e<T>.b bVarW = w();
                    if (bVarW != null) {
                        bVarW.h();
                        return;
                    }
                    return;
                }
                return;
            }
            if (e.f9153b.decrementAndGet(e.this) == 0) {
                o<List<? extends T>> oVar = this.f9156e;
                t0[] t0VarArr = e.this.f9154a;
                ArrayList arrayList = new ArrayList(t0VarArr.length);
                for (t0 t0Var : t0VarArr) {
                    arrayList.add(t0Var.getCompleted());
                }
                oVar.resumeWith(lc.j.b(arrayList));
            }
        }

        public final e<T>.b w() {
            return (b) f9155m.get(this);
        }

        public final e1 x() {
            e1 e1Var = this.f9157f;
            if (e1Var != null) {
                return e1Var;
            }
            kotlin.jvm.internal.k.o("handle");
            return null;
        }

        public final void y(e<T>.b bVar) {
            f9155m.set(this, bVar);
        }

        public final void z(e1 e1Var) {
            this.f9157f = e1Var;
        }
    }

    public final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e<T>.a[] f9159a;

        public b(e<T>.a[] aVarArr) {
            this.f9159a = aVarArr;
        }

        @Override // gd.n
        public void g(Throwable th) {
            h();
        }

        public final void h() {
            for (e<T>.a aVar : this.f9159a) {
                aVar.x().d();
            }
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
            g(th);
            return lc.q.f12711a;
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f9159a + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(t0<? extends T>[] t0VarArr) {
        this.f9154a = t0VarArr;
        this.notCompletedCount = t0VarArr.length;
    }

    public final Object c(oc.e<? super List<? extends T>> eVar) {
        p pVar = new p(pc.b.b(eVar), 1);
        pVar.B();
        int length = this.f9154a.length;
        a[] aVarArr = new a[length];
        for (int i10 = 0; i10 < length; i10++) {
            t0 t0Var = this.f9154a[i10];
            t0Var.start();
            a aVar = new a(pVar);
            aVar.z(t0Var.invokeOnCompletion(aVar));
            lc.q qVar = lc.q.f12711a;
            aVarArr[i10] = aVar;
        }
        e<T>.b bVar = new b(aVarArr);
        for (int i11 = 0; i11 < length; i11++) {
            aVarArr[i11].y(bVar);
        }
        if (pVar.isCompleted()) {
            bVar.h();
        } else {
            pVar.g(bVar);
        }
        Object objY = pVar.y();
        if (objY == pc.c.c()) {
            qc.h.c(eVar);
        }
        return objY;
    }
}
