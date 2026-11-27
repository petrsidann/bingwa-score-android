package d3;

import android.content.Context;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class t implements s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile u f6359e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n3.a f6360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n3.a f6361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j3.e f6362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k3.r f6363d;

    public t(n3.a aVar, n3.a aVar2, j3.e eVar, k3.r rVar, k3.v vVar) {
        this.f6360a = aVar;
        this.f6361b = aVar2;
        this.f6362c = eVar;
        this.f6363d = rVar;
        vVar.c();
    }

    public static t c() {
        u uVar = f6359e;
        if (uVar != null) {
            return uVar.e();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set<a3.c> d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(a3.c.b("proto"));
    }

    public static void f(Context context) {
        if (f6359e == null) {
            synchronized (t.class) {
                if (f6359e == null) {
                    f6359e = e.k().a(context).build();
                }
            }
        }
    }

    @Override // d3.s
    public void a(n nVar, a3.j jVar) {
        this.f6362c.a(nVar.f().f(nVar.c().c()), b(nVar), jVar);
    }

    public final i b(n nVar) {
        return i.a().i(this.f6360a.a()).k(this.f6361b.a()).j(nVar.g()).h(new h(nVar.b(), nVar.d())).g(nVar.c().a()).d();
    }

    public k3.r e() {
        return this.f6363d;
    }

    public a3.i g(f fVar) {
        return new p(d(fVar), o.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
