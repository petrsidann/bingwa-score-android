package k3;

import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f11508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l3.d f11509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f11510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m3.b f11511d;

    public v(Executor executor, l3.d dVar, x xVar, m3.b bVar) {
        this.f11508a = executor;
        this.f11509b = dVar;
        this.f11510c = xVar;
        this.f11511d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d() {
        Iterator<d3.o> it = this.f11509b.r().iterator();
        while (it.hasNext()) {
            this.f11510c.a(it.next(), 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f11511d.e(new m3.b.a() { // from class: k3.u
            @Override // m3.b.a
            public final Object a() {
                return this.f11507a.d();
            }
        });
    }

    public void c() {
        this.f11508a.execute(new Runnable() { // from class: k3.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f11506a.e();
            }
        });
    }
}
