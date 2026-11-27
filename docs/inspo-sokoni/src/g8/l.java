package g8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f8847f = TimeUnit.SECONDS.toMillis(15);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f8848g = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f8849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h1 f8850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j6.r<m> f8851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j6.r<o> f8852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8853e;

    public class a implements l4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l8.g.b f8854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l8.g f8855b;

        public a(l8.g gVar) {
            this.f8855b = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            l8.v.a("IndexBackfiller", "Documents written: %s", Integer.valueOf(l.this.d()));
            c(l.f8848g);
        }

        public final void c(long j10) {
            this.f8854a = this.f8855b.k(l8.g.d.INDEX_BACKFILL, j10, new Runnable() { // from class: g8.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8807a.b();
                }
            });
        }

        @Override // g8.l4
        public void start() {
            c(l.f8847f);
        }

        @Override // g8.l4
        public void stop() {
            l8.g.b bVar = this.f8854a;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(h1 h1Var, l8.g gVar, final k0 k0Var) {
        this(h1Var, gVar, new j6.r() { // from class: g8.h
            @Override // j6.r
            public final Object get() {
                return k0Var.E();
            }
        }, new j6.r() { // from class: g8.i
            @Override // j6.r
            public final Object get() {
                return k0Var.I();
            }
        });
        Objects.requireNonNull(k0Var);
    }

    public l(h1 h1Var, l8.g gVar, j6.r<m> rVar, j6.r<o> rVar2) {
        this.f8853e = 50;
        this.f8850b = h1Var;
        this.f8849a = new a(gVar);
        this.f8851c = rVar;
        this.f8852d = rVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer g() {
        return Integer.valueOf(i());
    }

    public int d() {
        return ((Integer) this.f8850b.k("Backfill Indexes", new l8.y() { // from class: g8.j
            @Override // l8.y
            public final Object get() {
                return this.f8788a.g();
            }
        })).intValue();
    }

    public final h8.p.a e(h8.p.a aVar, n nVar) {
        Iterator<Map.Entry<h8.k, h8.h>> it = nVar.c().iterator();
        h8.p.a aVar2 = aVar;
        while (it.hasNext()) {
            h8.p.a aVarL = h8.p.a.l(it.next().getValue());
            if (aVarL.compareTo(aVar2) > 0) {
                aVar2 = aVarL;
            }
        }
        return h8.p.a.i(aVar2.p(), aVar2.n(), Math.max(nVar.b(), aVar.o()));
    }

    public a f() {
        return this.f8849a;
    }

    public final int h(String str, int i10) {
        m mVar = this.f8851c.get();
        o oVar = this.f8852d.get();
        h8.p.a aVarL = mVar.l(str);
        n nVarK = oVar.k(str, aVarL, i10);
        mVar.e(nVarK.c());
        h8.p.a aVarE = e(aVarL, nVarK);
        l8.v.a("IndexBackfiller", "Updating offset: %s", aVarE);
        mVar.j(str, aVarE);
        return nVarK.c().size();
    }

    public final int i() {
        m mVar = this.f8851c.get();
        HashSet hashSet = new HashSet();
        int iH = this.f8853e;
        while (iH > 0) {
            String strG = mVar.g();
            if (strG == null || hashSet.contains(strG)) {
                break;
            }
            l8.v.a("IndexBackfiller", "Processing collection: %s", strG);
            iH -= h(strG, iH);
            hashSet.add(strG);
        }
        return this.f8853e - iH;
    }
}
