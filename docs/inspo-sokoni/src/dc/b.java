package dc;

import dc.b;
import j6.m;
import java.util.concurrent.Executor;
import vb.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<S extends b<S>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f6699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vb.c f6700b;

    public interface a<T extends b<T>> {
        T a(d dVar, vb.c cVar);
    }

    public b(d dVar, vb.c cVar) {
        this.f6699a = (d) m.p(dVar, "channel");
        this.f6700b = (vb.c) m.p(cVar, "callOptions");
    }

    public abstract S a(d dVar, vb.c cVar);

    public final vb.c b() {
        return this.f6700b;
    }

    public final S c(vb.b bVar) {
        return (S) a(this.f6699a, this.f6700b.l(bVar));
    }

    public final S d(Executor executor) {
        return (S) a(this.f6699a, this.f6700b.n(executor));
    }
}
