package d;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<c> f6164b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xc.a<lc.q> f6165c;

    public o(boolean z10) {
        this.f6163a = z10;
    }

    public final void a(c cancellable) {
        kotlin.jvm.internal.k.e(cancellable, "cancellable");
        this.f6164b.add(cancellable);
    }

    public final xc.a<lc.q> b() {
        return this.f6165c;
    }

    public void c() {
    }

    public abstract void d();

    public void e(b backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
    }

    public void f(b backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
    }

    public final boolean g() {
        return this.f6163a;
    }

    public final void h() {
        Iterator<T> it = this.f6164b.iterator();
        while (it.hasNext()) {
            ((c) it.next()).cancel();
        }
    }

    public final void i(c cancellable) {
        kotlin.jvm.internal.k.e(cancellable, "cancellable");
        this.f6164b.remove(cancellable);
    }

    public final void j(boolean z10) {
        this.f6163a = z10;
        xc.a<lc.q> aVar = this.f6165c;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void k(xc.a<lc.q> aVar) {
        this.f6165c = aVar;
    }
}
