package k3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e3.e f11489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l3.d f11490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f11491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f11492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m3.b f11493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n3.a f11494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n3.a f11495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l3.c f11496i;

    public r(Context context, e3.e eVar, l3.d dVar, x xVar, Executor executor, m3.b bVar, n3.a aVar, n3.a aVar2, l3.c cVar) {
        this.f11488a = context;
        this.f11489b = eVar;
        this.f11490c = dVar;
        this.f11491d = xVar;
        this.f11492e = executor;
        this.f11493f = bVar;
        this.f11494g = aVar;
        this.f11495h = aVar2;
        this.f11496i = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l(d3.o oVar) {
        return Boolean.valueOf(this.f11490c.Z(oVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterable m(d3.o oVar) {
        return this.f11490c.n(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable, d3.o oVar, long j10) {
        this.f11490c.S(iterable);
        this.f11490c.j(oVar, this.f11494g.a() + j10);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(Iterable iterable) {
        this.f11490c.h(iterable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p() {
        this.f11496i.d();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f11496i.t(((Integer) entry.getValue()).intValue(), g3.c.b.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(d3.o oVar, long j10) {
        this.f11490c.j(oVar, this.f11494g.a() + j10);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(d3.o oVar, int i10) {
        this.f11491d.a(oVar, i10 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final d3.o oVar, final int i10, Runnable runnable) {
        try {
            try {
                m3.b bVar = this.f11493f;
                final l3.d dVar = this.f11490c;
                Objects.requireNonNull(dVar);
                bVar.e(new m3.b.a() { // from class: k3.i
                    @Override // m3.b.a
                    public final Object a() {
                        return Integer.valueOf(dVar.g());
                    }
                });
                if (k()) {
                    u(oVar, i10);
                } else {
                    this.f11493f.e(new m3.b.a() { // from class: k3.j
                        @Override // m3.b.a
                        public final Object a() {
                            return this.f11469a.s(oVar, i10);
                        }
                    });
                }
            } catch (m3.a unused) {
                this.f11491d.a(oVar, i10 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    public d3.i j(e3.m mVar) {
        m3.b bVar = this.f11493f;
        final l3.c cVar = this.f11496i;
        Objects.requireNonNull(cVar);
        return mVar.b(d3.i.a().i(this.f11494g.a()).k(this.f11495h.a()).j("GDT_CLIENT_METRICS").h(new d3.h(a3.c.b("proto"), ((g3.a) bVar.e(new m3.b.a() { // from class: k3.h
            @Override // m3.b.a
            public final Object a() {
                return cVar.k();
            }
        })).f())).d());
    }

    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f11488a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public e3.g u(final d3.o oVar, int i10) {
        e3.g gVarA;
        e3.m mVarA = this.f11489b.a(oVar.b());
        long jMax = 0;
        e3.g gVarE = e3.g.e(0L);
        while (true) {
            final long j10 = jMax;
            while (true) {
                if (!((Boolean) this.f11493f.e(new m3.b.a() { // from class: k3.k
                    @Override // m3.b.a
                    public final Object a() {
                        return this.f11472a.l(oVar);
                    }
                })).booleanValue()) {
                    this.f11493f.e(new m3.b.a() { // from class: k3.q
                        @Override // m3.b.a
                        public final Object a() {
                            return this.f11485a.r(oVar, j10);
                        }
                    });
                    return gVarE;
                }
                final Iterable iterable = (Iterable) this.f11493f.e(new m3.b.a() { // from class: k3.l
                    @Override // m3.b.a
                    public final Object a() {
                        return this.f11474a.m(oVar);
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return gVarE;
                }
                if (mVarA == null) {
                    h3.a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", oVar);
                    gVarA = e3.g.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((l3.k) it.next()).b());
                    }
                    if (oVar.e()) {
                        arrayList.add(j(mVarA));
                    }
                    gVarA = mVarA.a(e3.f.a().b(arrayList).c(oVar.c()).a());
                }
                gVarE = gVarA;
                if (gVarE.c() == e3.g.a.TRANSIENT_ERROR) {
                    this.f11493f.e(new m3.b.a() { // from class: k3.m
                        @Override // m3.b.a
                        public final Object a() {
                            return this.f11476a.n(iterable, oVar, j10);
                        }
                    });
                    this.f11491d.b(oVar, i10 + 1, true);
                    return gVarE;
                }
                this.f11493f.e(new m3.b.a() { // from class: k3.n
                    @Override // m3.b.a
                    public final Object a() {
                        return this.f11480a.o(iterable);
                    }
                });
                if (gVarE.c() == e3.g.a.OK) {
                    break;
                }
                if (gVarE.c() == e3.g.a.INVALID_PAYLOAD) {
                    final HashMap map = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String strJ = ((l3.k) it2.next()).b().j();
                        map.put(strJ, !map.containsKey(strJ) ? 1 : Integer.valueOf(((Integer) map.get(strJ)).intValue() + 1));
                    }
                    this.f11493f.e(new m3.b.a() { // from class: k3.p
                        @Override // m3.b.a
                        public final Object a() {
                            return this.f11483a.q(map);
                        }
                    });
                }
            }
            jMax = Math.max(j10, gVarE.b());
            if (oVar.e()) {
                this.f11493f.e(new m3.b.a() { // from class: k3.o
                    @Override // m3.b.a
                    public final Object a() {
                        return this.f11482a.p();
                    }
                });
            }
        }
    }

    public void v(final d3.o oVar, final int i10, final Runnable runnable) {
        this.f11492e.execute(new Runnable() { // from class: k3.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f11463a.t(oVar, i10, runnable);
            }
        });
    }
}
