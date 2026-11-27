package j3;

import a3.j;
import d3.o;
import d3.t;
import e3.m;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import k3.x;

/* JADX INFO: loaded from: classes.dex */
public class c implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f11208f = Logger.getLogger(t.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f11209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f11210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e3.e f11211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l3.d f11212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m3.b f11213e;

    public c(Executor executor, e3.e eVar, x xVar, l3.d dVar, m3.b bVar) {
        this.f11210b = executor;
        this.f11211c = eVar;
        this.f11209a = xVar;
        this.f11212d = dVar;
        this.f11213e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d(o oVar, d3.i iVar) {
        this.f11212d.Y(oVar, iVar);
        this.f11209a.a(oVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(final o oVar, j jVar, d3.i iVar) {
        try {
            m mVarA = this.f11211c.a(oVar.b());
            if (mVarA == null) {
                String str = String.format("Transport backend '%s' is not registered", oVar.b());
                f11208f.warning(str);
                jVar.a(new IllegalArgumentException(str));
            } else {
                final d3.i iVarB = mVarA.b(iVar);
                this.f11213e.e(new m3.b.a() { // from class: j3.b
                    @Override // m3.b.a
                    public final Object a() {
                        return this.f11205a.d(oVar, iVarB);
                    }
                });
                jVar.a(null);
            }
        } catch (Exception e10) {
            f11208f.warning("Error scheduling event " + e10.getMessage());
            jVar.a(e10);
        }
    }

    @Override // j3.e
    public void a(final o oVar, final d3.i iVar, final j jVar) {
        this.f11210b.execute(new Runnable() { // from class: j3.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f11201a.e(oVar, jVar, iVar);
            }
        });
    }
}
