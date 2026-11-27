package g8;

import android.util.SparseArray;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class q0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f8907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f8908d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f8909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f8910b;

    public class a implements l4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l8.g f8911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k0 f8912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8913c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public l8.g.b f8914d;

        public a(l8.g gVar, k0 k0Var) {
            this.f8911a = gVar;
            this.f8912b = k0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            this.f8912b.z(q0.this);
            this.f8913c = true;
            c();
        }

        public final void c() {
            this.f8914d = this.f8911a.k(l8.g.d.GARBAGE_COLLECTION, this.f8913c ? q0.f8908d : q0.f8907c, new Runnable() { // from class: g8.p0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8901a.b();
                }
            });
        }

        @Override // g8.l4
        public void start() {
            if (q0.this.f8910b.f8916a != -1) {
                c();
            }
        }

        @Override // g8.l4
        public void stop() {
            l8.g.b bVar = this.f8914d;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8918c;

        public b(long j10, int i10, int i11) {
            this.f8916a = j10;
            this.f8917b = i10;
            this.f8918c = i11;
        }

        public static b a(long j10) {
            return new b(j10, 10, 1000);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f8919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f8922d;

        public c(boolean z10, int i10, int i11, int i12) {
            this.f8919a = z10;
            this.f8920b = i10;
            this.f8921c = i11;
            this.f8922d = i12;
        }

        public static c a() {
            return new c(false, 0, 0, 0);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Comparator<Long> f8923c = new Comparator() { // from class: g8.r0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return q0.d.d((Long) obj, (Long) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PriorityQueue<Long> f8924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8925b;

        public d(int i10) {
            this.f8925b = i10;
            this.f8924a = new PriorityQueue<>(i10, f8923c);
        }

        public static /* synthetic */ int d(Long l10, Long l11) {
            return l11.compareTo(l10);
        }

        public void b(Long l10) {
            if (this.f8924a.size() >= this.f8925b) {
                if (l10.longValue() >= this.f8924a.peek().longValue()) {
                    return;
                } else {
                    this.f8924a.poll();
                }
            }
            this.f8924a.add(l10);
        }

        public long c() {
            return this.f8924a.peek().longValue();
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f8907c = timeUnit.toMillis(1L);
        f8908d = timeUnit.toMillis(5L);
    }

    public q0(m0 m0Var, b bVar) {
        this.f8909a = m0Var;
        this.f8910b = bVar;
    }

    public static /* synthetic */ void i(d dVar, n4 n4Var) {
        dVar.b(Long.valueOf(n4Var.e()));
    }

    public int e(int i10) {
        return (int) ((i10 / 100.0f) * this.f8909a.j());
    }

    public c f(SparseArray<?> sparseArray) {
        if (this.f8910b.f8916a == -1) {
            l8.v.a("LruGarbageCollector", "Garbage collection skipped; disabled", new Object[0]);
        } else {
            long jG = g();
            if (jG >= this.f8910b.f8916a) {
                return m(sparseArray);
            }
            l8.v.a("LruGarbageCollector", "Garbage collection skipped; Cache size " + jG + " is lower than threshold " + this.f8910b.f8916a, new Object[0]);
        }
        return c.a();
    }

    public long g() {
        return this.f8909a.m();
    }

    public long h(int i10) {
        if (i10 == 0) {
            return -1L;
        }
        final d dVar = new d(i10);
        this.f8909a.g(new l8.n() { // from class: g8.n0
            @Override // l8.n
            public final void accept(Object obj) {
                q0.i(dVar, (n4) obj);
            }
        });
        this.f8909a.o(new l8.n() { // from class: g8.o0
            @Override // l8.n
            public final void accept(Object obj) {
                dVar.b((Long) obj);
            }
        });
        return dVar.c();
    }

    public a j(l8.g gVar, k0 k0Var) {
        return new a(gVar, k0Var);
    }

    public int k(long j10) {
        return this.f8909a.k(j10);
    }

    public int l(long j10, SparseArray<?> sparseArray) {
        return this.f8909a.a(j10, sparseArray);
    }

    public final c m(SparseArray<?> sparseArray) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iE = e(this.f8910b.f8917b);
        if (iE > this.f8910b.f8918c) {
            l8.v.a("LruGarbageCollector", "Capping sequence numbers to collect down to the maximum of " + this.f8910b.f8918c + " from " + iE, new Object[0]);
            iE = this.f8910b.f8918c;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long jH = h(iE);
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        int iL = l(jH, sparseArray);
        long jCurrentTimeMillis4 = System.currentTimeMillis();
        int iK = k(jH);
        long jCurrentTimeMillis5 = System.currentTimeMillis();
        if (l8.v.c()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("LRU Garbage Collection:\n\tCounted targets in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms\n");
            Locale locale = Locale.ROOT;
            sb2.append(String.format(locale, "\tDetermined least recently used %d sequence numbers in %dms\n", Integer.valueOf(iE), Long.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis2)));
            l8.v.a("LruGarbageCollector", ((sb2.toString() + String.format(locale, "\tRemoved %d targets in %dms\n", Integer.valueOf(iL), Long.valueOf(jCurrentTimeMillis4 - jCurrentTimeMillis3))) + String.format(locale, "\tRemoved %d documents in %dms\n", Integer.valueOf(iK), Long.valueOf(jCurrentTimeMillis5 - jCurrentTimeMillis4))) + String.format(locale, "Total Duration: %dms", Long.valueOf(jCurrentTimeMillis5 - jCurrentTimeMillis)), new Object[0]);
        }
        return new c(true, iE, iL, iK);
    }
}
