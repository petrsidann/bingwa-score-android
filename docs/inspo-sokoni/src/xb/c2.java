package xb;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c2<ReqT> implements xb.r {
    public static final vb.a1.g<String> A;
    public static final vb.a1.g<String> B;
    public static final vb.l1 C;
    public static Random D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.b1<ReqT, ?> f18266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18267b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f18269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vb.a1 f18270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d2 f18271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t0 f18272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18273h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t f18275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f18276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f18277l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d0 f18278m;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public y f18284s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f18285t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public xb.s f18286u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public u f18287v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public u f18288w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f18289x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public vb.l1 f18290y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f18291z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f18268c = new vb.p1(new a());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f18274i = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final x0 f18279n = new x0();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile a0 f18280o = new a0(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f18281p = new AtomicBoolean();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f18282q = new AtomicInteger();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicInteger f18283r = new AtomicInteger();

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw vb.l1.k(th).q("Uncaught exception in the SynchronizationContext. Re-thrown.").d();
        }
    }

    public static final class a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<r> f18294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Collection<c0> f18295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Collection<c0> f18296d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f18297e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c0 f18298f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f18299g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f18300h;

        public a0(List<r> list, Collection<c0> collection, Collection<c0> collection2, c0 c0Var, boolean z10, boolean z11, boolean z12, int i10) {
            this.f18294b = list;
            this.f18295c = (Collection) j6.m.p(collection, "drainedSubstreams");
            this.f18298f = c0Var;
            this.f18296d = collection2;
            this.f18299g = z10;
            this.f18293a = z11;
            this.f18300h = z12;
            this.f18297e = i10;
            j6.m.v(!z11 || list == null, "passThrough should imply buffer is null");
            j6.m.v((z11 && c0Var == null) ? false : true, "passThrough should imply winningSubstream != null");
            j6.m.v(!z11 || (collection.size() == 1 && collection.contains(c0Var)) || (collection.size() == 0 && c0Var.f18322b), "passThrough should imply winningSubstream is drained");
            j6.m.v((z10 && c0Var == null) ? false : true, "cancelled should imply committed");
        }

        public a0 a(c0 c0Var) {
            Collection collectionUnmodifiableCollection;
            j6.m.v(!this.f18300h, "hedging frozen");
            j6.m.v(this.f18298f == null, "already committed");
            if (this.f18296d == null) {
                collectionUnmodifiableCollection = Collections.singleton(c0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f18296d);
                arrayList.add(c0Var);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new a0(this.f18294b, this.f18295c, collectionUnmodifiableCollection, this.f18298f, this.f18299g, this.f18293a, this.f18300h, this.f18297e + 1);
        }

        public a0 b() {
            return new a0(this.f18294b, this.f18295c, this.f18296d, this.f18298f, true, this.f18293a, this.f18300h, this.f18297e);
        }

        public a0 c(c0 c0Var) {
            List<r> list;
            Collection collectionEmptyList;
            boolean z10;
            j6.m.v(this.f18298f == null, "Already committed");
            List<r> list2 = this.f18294b;
            if (this.f18295c.contains(c0Var)) {
                collectionEmptyList = Collections.singleton(c0Var);
                z10 = true;
                list = null;
            } else {
                list = list2;
                collectionEmptyList = Collections.emptyList();
                z10 = false;
            }
            return new a0(list, collectionEmptyList, this.f18296d, c0Var, this.f18299g, z10, this.f18300h, this.f18297e);
        }

        public a0 d() {
            return this.f18300h ? this : new a0(this.f18294b, this.f18295c, this.f18296d, this.f18298f, this.f18299g, this.f18293a, true, this.f18297e);
        }

        public a0 e(c0 c0Var) {
            ArrayList arrayList = new ArrayList(this.f18296d);
            arrayList.remove(c0Var);
            return new a0(this.f18294b, this.f18295c, Collections.unmodifiableCollection(arrayList), this.f18298f, this.f18299g, this.f18293a, this.f18300h, this.f18297e);
        }

        public a0 f(c0 c0Var, c0 c0Var2) {
            ArrayList arrayList = new ArrayList(this.f18296d);
            arrayList.remove(c0Var);
            arrayList.add(c0Var2);
            return new a0(this.f18294b, this.f18295c, Collections.unmodifiableCollection(arrayList), this.f18298f, this.f18299g, this.f18293a, this.f18300h, this.f18297e);
        }

        public a0 g(c0 c0Var) {
            c0Var.f18322b = true;
            if (!this.f18295c.contains(c0Var)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.f18295c);
            arrayList.remove(c0Var);
            return new a0(this.f18294b, Collections.unmodifiableCollection(arrayList), this.f18296d, this.f18298f, this.f18299g, this.f18293a, this.f18300h, this.f18297e);
        }

        public a0 h(c0 c0Var) {
            Collection collectionUnmodifiableCollection;
            j6.m.v(!this.f18293a, "Already passThrough");
            if (c0Var.f18322b) {
                collectionUnmodifiableCollection = this.f18295c;
            } else if (this.f18295c.isEmpty()) {
                collectionUnmodifiableCollection = Collections.singletonList(c0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f18295c);
                arrayList.add(c0Var);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = collectionUnmodifiableCollection;
            c0 c0Var2 = this.f18298f;
            boolean z10 = c0Var2 != null;
            List<r> list = this.f18294b;
            if (z10) {
                j6.m.v(c0Var2 == c0Var, "Another RPC attempt has already committed");
                list = null;
            }
            return new a0(list, collection, this.f18296d, this.f18298f, this.f18299g, z10, this.f18300h, this.f18297e);
        }
    }

    public class b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18301a;

        public b(String str) {
            this.f18301a = str;
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.i(this.f18301a);
        }
    }

    public final class b0 implements xb.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f18303a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.a1 f18305a;

            public a(vb.a1 a1Var) {
                this.f18305a = a1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                c2.this.f18286u.d(this.f18305a);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c0 f18307a;

            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    c2.this.f0(bVar.f18307a);
                }
            }

            public b(c0 c0Var) {
                this.f18307a = c0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                c2.this.f18267b.execute(new a());
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c2.this.f18291z = true;
                c2.this.f18286u.c(c2.this.f18284s.f18370a, c2.this.f18284s.f18371b, c2.this.f18284s.f18372c);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c0 f18311a;

            public d(c0 c0Var) {
                this.f18311a = c0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                c2.this.f0(this.f18311a);
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q2.a f18313a;

            public e(q2.a aVar) {
                this.f18313a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c2.this.f18286u.a(this.f18313a);
            }
        }

        public class f implements Runnable {
            public f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c2.this.f18291z) {
                    return;
                }
                c2.this.f18286u.b();
            }
        }

        public b0(c0 c0Var) {
            this.f18303a = c0Var;
        }

        @Override // xb.q2
        public void a(q2.a aVar) {
            a0 a0Var = c2.this.f18280o;
            j6.m.v(a0Var.f18298f != null, "Headers should be received prior to messages.");
            if (a0Var.f18298f != this.f18303a) {
                r0.e(aVar);
            } else {
                c2.this.f18268c.execute(new e(aVar));
            }
        }

        @Override // xb.q2
        public void b() {
            if (c2.this.c()) {
                c2.this.f18268c.execute(new f());
            }
        }

        @Override // xb.s
        public void c(vb.l1 l1Var, xb.s.a aVar, vb.a1 a1Var) {
            u uVar;
            synchronized (c2.this.f18274i) {
                c2 c2Var = c2.this;
                c2Var.f18280o = c2Var.f18280o.g(this.f18303a);
                c2.this.f18279n.a(l1Var.m());
            }
            if (c2.this.f18283r.decrementAndGet() == Integer.MIN_VALUE) {
                c2.this.f18268c.execute(new c());
                return;
            }
            c0 c0Var = this.f18303a;
            if (c0Var.f18323c) {
                c2.this.c0(c0Var);
                if (c2.this.f18280o.f18298f == this.f18303a) {
                    c2.this.m0(l1Var, aVar, a1Var);
                    return;
                }
                return;
            }
            xb.s.a aVar2 = xb.s.a.MISCARRIED;
            if (aVar == aVar2 && c2.this.f18282q.incrementAndGet() > 1000) {
                c2.this.c0(this.f18303a);
                if (c2.this.f18280o.f18298f == this.f18303a) {
                    c2.this.m0(vb.l1.f17419s.q("Too many transparent retries. Might be a bug in gRPC").p(l1Var.d()), aVar, a1Var);
                    return;
                }
                return;
            }
            if (c2.this.f18280o.f18298f == null) {
                if (aVar == aVar2 || (aVar == xb.s.a.REFUSED && c2.this.f18281p.compareAndSet(false, true))) {
                    c0 c0VarD0 = c2.this.d0(this.f18303a.f18324d, true);
                    if (c0VarD0 == null) {
                        return;
                    }
                    if (c2.this.f18273h) {
                        synchronized (c2.this.f18274i) {
                            c2 c2Var2 = c2.this;
                            c2Var2.f18280o = c2Var2.f18280o.f(this.f18303a, c0VarD0);
                        }
                    }
                    c2.this.f18267b.execute(new d(c0VarD0));
                    return;
                }
                if (aVar != xb.s.a.DROPPED) {
                    c2.this.f18281p.set(true);
                    if (c2.this.f18273h) {
                        v vVarF = f(l1Var, a1Var);
                        if (vVarF.f18362a) {
                            c2.this.l0(vVarF.f18363b);
                        }
                        synchronized (c2.this.f18274i) {
                            c2 c2Var3 = c2.this;
                            c2Var3.f18280o = c2Var3.f18280o.e(this.f18303a);
                            if (vVarF.f18362a) {
                                c2 c2Var4 = c2.this;
                                if (c2Var4.h0(c2Var4.f18280o) || !c2.this.f18280o.f18296d.isEmpty()) {
                                    return;
                                }
                            }
                        }
                    } else {
                        x xVarG = g(l1Var, a1Var);
                        if (xVarG.f18368a) {
                            c0 c0VarD1 = c2.this.d0(this.f18303a.f18324d + 1, false);
                            if (c0VarD1 == null) {
                                return;
                            }
                            synchronized (c2.this.f18274i) {
                                c2 c2Var5 = c2.this;
                                uVar = new u(c2Var5.f18274i);
                                c2Var5.f18287v = uVar;
                            }
                            uVar.c(c2.this.f18269d.schedule(new b(c0VarD1), xVarG.f18369b, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                } else if (c2.this.f18273h) {
                    c2.this.g0();
                }
            }
            c2.this.c0(this.f18303a);
            if (c2.this.f18280o.f18298f == this.f18303a) {
                c2.this.m0(l1Var, aVar, a1Var);
            }
        }

        @Override // xb.s
        public void d(vb.a1 a1Var) {
            if (this.f18303a.f18324d > 0) {
                vb.a1.g<String> gVar = c2.A;
                a1Var.e(gVar);
                a1Var.p(gVar, String.valueOf(this.f18303a.f18324d));
            }
            c2.this.c0(this.f18303a);
            if (c2.this.f18280o.f18298f == this.f18303a) {
                if (c2.this.f18278m != null) {
                    c2.this.f18278m.c();
                }
                c2.this.f18268c.execute(new a(a1Var));
            }
        }

        public final Integer e(vb.a1 a1Var) {
            String str = (String) a1Var.g(c2.B);
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public final v f(vb.l1 l1Var, vb.a1 a1Var) {
            Integer numE = e(a1Var);
            boolean z10 = !c2.this.f18272g.f18966c.contains(l1Var.m());
            boolean z11 = (c2.this.f18278m == null || (z10 && (numE == null || numE.intValue() >= 0))) ? false : !c2.this.f18278m.b();
            if (!z10 && !z11 && !l1Var.o() && numE != null && numE.intValue() > 0) {
                numE = 0;
            }
            return new v((z10 || z11) ? false : true, numE);
        }

        public final x g(vb.l1 l1Var, vb.a1 a1Var) {
            c2 c2Var;
            long jMin;
            long nanos = 0;
            boolean z10 = false;
            if (c2.this.f18271f == null) {
                return new x(false, 0L);
            }
            boolean zContains = c2.this.f18271f.f18417f.contains(l1Var.m());
            Integer numE = e(a1Var);
            boolean z11 = (c2.this.f18278m == null || (!zContains && (numE == null || numE.intValue() >= 0))) ? false : !c2.this.f18278m.b();
            if (c2.this.f18271f.f18412a > this.f18303a.f18324d + 1 && !z11) {
                if (numE == null) {
                    if (zContains) {
                        nanos = (long) (c2.this.f18289x * c2.D.nextDouble());
                        c2Var = c2.this;
                        jMin = Math.min((long) (c2Var.f18289x * c2.this.f18271f.f18415d), c2.this.f18271f.f18414c);
                        c2Var.f18289x = jMin;
                        z10 = true;
                    }
                } else if (numE.intValue() >= 0) {
                    nanos = TimeUnit.MILLISECONDS.toNanos(numE.intValue());
                    c2Var = c2.this;
                    jMin = c2Var.f18271f.f18413b;
                    c2Var.f18289x = jMin;
                    z10 = true;
                }
            }
            return new x(z10, nanos);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f18316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c0 f18317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Future f18318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Future f18319d;

        public c(Collection collection, c0 c0Var, Future future, Future future2) {
            this.f18316a = collection;
            this.f18317b = c0Var;
            this.f18318c = future;
            this.f18319d = future2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (c0 c0Var : this.f18316a) {
                if (c0Var != this.f18317b) {
                    c0Var.f18321a.a(c2.C);
                }
            }
            Future future = this.f18318c;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.f18319d;
            if (future2 != null) {
                future2.cancel(false);
            }
            c2.this.j0();
        }
    }

    public static final class c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public xb.r f18321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f18324d;

        public c0(int i10) {
            this.f18324d = i10;
        }
    }

    public class d implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.o f18325a;

        public d(vb.o oVar) {
            this.f18325a = oVar;
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.b(this.f18325a);
        }
    }

    public static final class d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f18330d;

        public d0(float f10, float f11) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f18330d = atomicInteger;
            this.f18329c = (int) (f11 * 1000.0f);
            int i10 = (int) (f10 * 1000.0f);
            this.f18327a = i10;
            this.f18328b = i10 / 2;
            atomicInteger.set(i10);
        }

        public boolean a() {
            return this.f18330d.get() > this.f18328b;
        }

        public boolean b() {
            int i10;
            int i11;
            do {
                i10 = this.f18330d.get();
                if (i10 == 0) {
                    return false;
                }
                i11 = i10 - 1000;
            } while (!this.f18330d.compareAndSet(i10, Math.max(i11, 0)));
            return i11 > this.f18328b;
        }

        public void c() {
            int i10;
            int i11;
            do {
                i10 = this.f18330d.get();
                i11 = this.f18327a;
                if (i10 == i11) {
                    return;
                }
            } while (!this.f18330d.compareAndSet(i10, Math.min(this.f18329c + i10, i11)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d0)) {
                return false;
            }
            d0 d0Var = (d0) obj;
            return this.f18327a == d0Var.f18327a && this.f18329c == d0Var.f18329c;
        }

        public int hashCode() {
            return j6.i.b(Integer.valueOf(this.f18327a), Integer.valueOf(this.f18329c));
        }
    }

    public class e implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.u f18331a;

        public e(vb.u uVar) {
            this.f18331a = uVar;
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.o(this.f18331a);
        }
    }

    public class f implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.w f18333a;

        public f(vb.w wVar) {
            this.f18333a = wVar;
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.h(this.f18333a);
        }
    }

    public class g implements r {
        public g() {
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.flush();
        }
    }

    public class h implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18336a;

        public h(boolean z10) {
            this.f18336a = z10;
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.p(this.f18336a);
        }
    }

    public class i implements r {
        public i() {
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.j();
        }
    }

    public class j implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18339a;

        public j(int i10) {
            this.f18339a = i10;
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.e(this.f18339a);
        }
    }

    public class k implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18341a;

        public k(int i10) {
            this.f18341a = i10;
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.f(this.f18341a);
        }
    }

    public class l implements r {
        public l() {
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.l();
        }
    }

    public class m implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18344a;

        public m(int i10) {
            this.f18344a = i10;
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.d(this.f18344a);
        }
    }

    public class n implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f18346a;

        public n(Object obj) {
            this.f18346a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.k(c2.this.f18266a.j(this.f18346a));
            c0Var.f18321a.flush();
        }
    }

    public class o extends vb.k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.k f18348a;

        public o(vb.k kVar) {
            this.f18348a = kVar;
        }

        @Override // vb.k.a
        public vb.k a(vb.k.b bVar, vb.a1 a1Var) {
            return this.f18348a;
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c2.this.f18291z) {
                return;
            }
            c2.this.f18286u.b();
        }
    }

    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.l1 f18351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ xb.s.a f18352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ vb.a1 f18353c;

        public q(vb.l1 l1Var, xb.s.a aVar, vb.a1 a1Var) {
            this.f18351a = l1Var;
            this.f18352b = aVar;
            this.f18353c = a1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            c2.this.f18291z = true;
            c2.this.f18286u.c(this.f18351a, this.f18352b, this.f18353c);
        }
    }

    public interface r {
        void a(c0 c0Var);
    }

    public class s extends vb.k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c0 f18355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f18356c;

        public s(c0 c0Var) {
            this.f18355b = c0Var;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0073 A[Catch: all -> 0x0084, TryCatch #0 {, blocks: (B:7:0x0012, B:9:0x001c, B:12:0x0023, B:14:0x0032, B:16:0x0034, B:18:0x0041, B:19:0x0043, B:23:0x006d, B:25:0x0073, B:27:0x007b, B:20:0x0046, B:22:0x006a, B:31:0x0082), top: B:36:0x0012 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x007a  */
        /* JADX WARN: Code duplicated, block: B:29:0x007e  */
        /* JADX WARN: Code duplicated, block: B:37:? A[RETURN, SYNTHETIC] */
        @Override // vb.o1
        public void h(long j10) {
            c0 c0Var;
            c0 c0Var2;
            Runnable runnableB0;
            if (c2.this.f18280o.f18298f != null) {
                return;
            }
            synchronized (c2.this.f18274i) {
                if (c2.this.f18280o.f18298f == null && !this.f18355b.f18322b) {
                    long j11 = this.f18356c + j10;
                    this.f18356c = j11;
                    if (j11 <= c2.this.f18285t) {
                        return;
                    }
                    if (this.f18356c <= c2.this.f18276k) {
                        long jA = c2.this.f18275j.a(this.f18356c - c2.this.f18285t);
                        c2.this.f18285t = this.f18356c;
                        if (jA > c2.this.f18277l) {
                            c0Var = this.f18355b;
                        }
                        c0Var2 = this.f18355b;
                        if (c0Var2.f18323c) {
                            runnableB0 = c2.this.b0(c0Var2);
                        } else {
                            runnableB0 = null;
                        }
                        if (runnableB0 != null) {
                            runnableB0.run();
                        }
                    }
                    c0Var = this.f18355b;
                    c0Var.f18323c = true;
                    c0Var2 = this.f18355b;
                    if (c0Var2.f18323c) {
                        runnableB0 = c2.this.b0(c0Var2);
                    } else {
                        runnableB0 = null;
                    }
                    if (runnableB0 != null) {
                        runnableB0.run();
                    }
                }
            }
        }
    }

    public static final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLong f18358a = new AtomicLong();

        public long a(long j10) {
            return this.f18358a.addAndGet(j10);
        }
    }

    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f18359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Future<?> f18360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18361c;

        public u(Object obj) {
            this.f18359a = obj;
        }

        public boolean a() {
            return this.f18361c;
        }

        public Future<?> b() {
            this.f18361c = true;
            return this.f18360b;
        }

        public void c(Future<?> future) {
            synchronized (this.f18359a) {
                if (!this.f18361c) {
                    this.f18360b = future;
                }
            }
        }
    }

    public static final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f18363b;

        public v(boolean z10, Integer num) {
            this.f18362a = z10;
            this.f18363b = num;
        }
    }

    public final class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f18364a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c0 f18366a;

            public a(c0 c0Var) {
                this.f18366a = c0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                u uVar;
                c2 c2Var;
                boolean z10;
                synchronized (c2.this.f18274i) {
                    uVar = null;
                    if (w.this.f18364a.a()) {
                        z10 = true;
                    } else {
                        c2 c2Var2 = c2.this;
                        c2Var2.f18280o = c2Var2.f18280o.a(this.f18366a);
                        c2 c2Var3 = c2.this;
                        if (c2Var3.h0(c2Var3.f18280o) && (c2.this.f18278m == null || c2.this.f18278m.a())) {
                            c2Var = c2.this;
                            uVar = new u(c2Var.f18274i);
                        } else {
                            c2 c2Var4 = c2.this;
                            c2Var4.f18280o = c2Var4.f18280o.d();
                            c2Var = c2.this;
                        }
                        c2Var.f18288w = uVar;
                        z10 = false;
                    }
                }
                if (z10) {
                    this.f18366a.f18321a.g(new b0(this.f18366a));
                    this.f18366a.f18321a.a(vb.l1.f17406f.q("Unneeded hedging"));
                } else {
                    if (uVar != null) {
                        uVar.c(c2.this.f18269d.schedule(new w(uVar), c2.this.f18272g.f18965b, TimeUnit.NANOSECONDS));
                    }
                    c2.this.f0(this.f18366a);
                }
            }
        }

        public w(u uVar) {
            this.f18364a = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c2 c2Var = c2.this;
            c0 c0VarD0 = c2Var.d0(c2Var.f18280o.f18297e, false);
            if (c0VarD0 == null) {
                return;
            }
            c2.this.f18267b.execute(new a(c0VarD0));
        }
    }

    public static final class x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f18369b;

        public x(boolean z10, long j10) {
            this.f18368a = z10;
            this.f18369b = j10;
        }
    }

    public static final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.l1 f18370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xb.s.a f18371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vb.a1 f18372c;

        public y(vb.l1 l1Var, xb.s.a aVar, vb.a1 a1Var) {
            this.f18370a = l1Var;
            this.f18371b = aVar;
            this.f18372c = a1Var;
        }
    }

    public class z implements r {
        public z() {
        }

        @Override // xb.c2.r
        public void a(c0 c0Var) {
            c0Var.f18321a.g(new b0(c0Var));
        }
    }

    static {
        vb.a1.d<String> dVar = vb.a1.f17241e;
        A = vb.a1.g.e("grpc-previous-rpc-attempts", dVar);
        B = vb.a1.g.e("grpc-retry-pushback-ms", dVar);
        C = vb.l1.f17406f.q("Stream thrown away because RetriableStream committed");
        D = new Random();
    }

    public c2(vb.b1<ReqT, ?> b1Var, vb.a1 a1Var, t tVar, long j10, long j11, Executor executor, ScheduledExecutorService scheduledExecutorService, d2 d2Var, t0 t0Var, d0 d0Var) {
        this.f18266a = b1Var;
        this.f18275j = tVar;
        this.f18276k = j10;
        this.f18277l = j11;
        this.f18267b = executor;
        this.f18269d = scheduledExecutorService;
        this.f18270e = a1Var;
        this.f18271f = d2Var;
        if (d2Var != null) {
            this.f18289x = d2Var.f18413b;
        }
        this.f18272g = t0Var;
        j6.m.e(d2Var == null || t0Var == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.f18273h = t0Var != null;
        this.f18278m = d0Var;
    }

    @Override // xb.r
    public final void a(vb.l1 l1Var) {
        c0 c0Var;
        c0 c0Var2 = new c0(0);
        c0Var2.f18321a = new o1();
        Runnable runnableB0 = b0(c0Var2);
        if (runnableB0 != null) {
            synchronized (this.f18274i) {
                this.f18280o = this.f18280o.h(c0Var2);
            }
            runnableB0.run();
            m0(l1Var, xb.s.a.PROCESSED, new vb.a1());
            return;
        }
        synchronized (this.f18274i) {
            if (this.f18280o.f18295c.contains(this.f18280o.f18298f)) {
                c0Var = this.f18280o.f18298f;
            } else {
                this.f18290y = l1Var;
                c0Var = null;
            }
            this.f18280o = this.f18280o.b();
        }
        if (c0Var != null) {
            c0Var.f18321a.a(l1Var);
        }
    }

    @Override // xb.p2
    public final void b(vb.o oVar) {
        e0(new d(oVar));
    }

    public final Runnable b0(c0 c0Var) {
        Future<?> future;
        Future<?> future2;
        synchronized (this.f18274i) {
            if (this.f18280o.f18298f != null) {
                return null;
            }
            Collection<c0> collection = this.f18280o.f18295c;
            this.f18280o = this.f18280o.c(c0Var);
            this.f18275j.a(-this.f18285t);
            u uVar = this.f18287v;
            if (uVar != null) {
                Future<?> futureB = uVar.b();
                this.f18287v = null;
                future = futureB;
            } else {
                future = null;
            }
            u uVar2 = this.f18288w;
            if (uVar2 != null) {
                Future<?> futureB2 = uVar2.b();
                this.f18288w = null;
                future2 = futureB2;
            } else {
                future2 = null;
            }
            return new c(collection, c0Var, future, future2);
        }
    }

    @Override // xb.p2
    public final boolean c() {
        Iterator<c0> it = this.f18280o.f18295c.iterator();
        while (it.hasNext()) {
            if (it.next().f18321a.c()) {
                return true;
            }
        }
        return false;
    }

    public final void c0(c0 c0Var) {
        Runnable runnableB0 = b0(c0Var);
        if (runnableB0 != null) {
            this.f18267b.execute(runnableB0);
        }
    }

    @Override // xb.p2
    public final void d(int i10) {
        a0 a0Var = this.f18280o;
        if (a0Var.f18293a) {
            a0Var.f18298f.f18321a.d(i10);
        } else {
            e0(new m(i10));
        }
    }

    public final c0 d0(int i10, boolean z10) {
        int i11;
        do {
            i11 = this.f18283r.get();
            if (i11 < 0) {
                return null;
            }
        } while (!this.f18283r.compareAndSet(i11, i11 + 1));
        c0 c0Var = new c0(i10);
        c0Var.f18321a = i0(o0(this.f18270e, i10), new o(new s(c0Var)), i10, z10);
        return c0Var;
    }

    @Override // xb.r
    public final void e(int i10) {
        e0(new j(i10));
    }

    public final void e0(r rVar) {
        Collection<c0> collection;
        synchronized (this.f18274i) {
            if (!this.f18280o.f18293a) {
                this.f18280o.f18294b.add(rVar);
            }
            collection = this.f18280o.f18295c;
        }
        Iterator<c0> it = collection.iterator();
        while (it.hasNext()) {
            rVar.a(it.next());
        }
    }

    @Override // xb.r
    public final void f(int i10) {
        e0(new k(i10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0084, code lost:
    
        r0 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008c, code lost:
    
        if (r0.hasNext() == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        r4 = (xb.c2.r) r0.next();
        r4.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0099, code lost:
    
        if ((r4 instanceof xb.c2.z) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009b, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
    
        r4 = r8.f18280o;
        r5 = r4.f18298f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:
    
        if (r5 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a2, code lost:
    
        if (r5 == r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a7, code lost:
    
        if (r4.f18299g == false) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(c0 c0Var) {
        int iMin;
        int i10 = 0;
        p pVar = null;
        boolean z10 = false;
        ArrayList arrayList = null;
        while (true) {
            synchronized (this.f18274i) {
                a0 a0Var = this.f18280o;
                c0 c0Var2 = a0Var.f18298f;
                if ((c0Var2 != null && c0Var2 != c0Var) || a0Var.f18299g) {
                    break;
                    break;
                }
                if (i10 == a0Var.f18294b.size()) {
                    this.f18280o = a0Var.h(c0Var);
                    if (c()) {
                        pVar = new p();
                        break;
                    }
                    return;
                }
                if (c0Var.f18322b) {
                    return;
                }
                iMin = Math.min(i10 + 128, a0Var.f18294b.size());
                if (arrayList == null) {
                    arrayList = new ArrayList(a0Var.f18294b.subList(i10, iMin));
                } else {
                    arrayList.clear();
                    arrayList.addAll(a0Var.f18294b.subList(i10, iMin));
                }
            }
            i10 = iMin;
        }
        if (pVar != null) {
            this.f18268c.execute(pVar);
            return;
        }
        if (!z10) {
            c0Var.f18321a.g(new b0(c0Var));
        }
        c0Var.f18321a.a(this.f18280o.f18298f == c0Var ? this.f18290y : C);
    }

    @Override // xb.p2
    public final void flush() {
        a0 a0Var = this.f18280o;
        if (a0Var.f18293a) {
            a0Var.f18298f.f18321a.flush();
        } else {
            e0(new g());
        }
    }

    @Override // xb.r
    public final void g(xb.s sVar) {
        u uVar;
        d0 d0Var;
        this.f18286u = sVar;
        vb.l1 l1VarK0 = k0();
        if (l1VarK0 != null) {
            a(l1VarK0);
            return;
        }
        synchronized (this.f18274i) {
            this.f18280o.f18294b.add(new z());
        }
        c0 c0VarD0 = d0(0, false);
        if (c0VarD0 == null) {
            return;
        }
        if (this.f18273h) {
            synchronized (this.f18274i) {
                this.f18280o = this.f18280o.a(c0VarD0);
                if (h0(this.f18280o) && ((d0Var = this.f18278m) == null || d0Var.a())) {
                    uVar = new u(this.f18274i);
                    this.f18288w = uVar;
                } else {
                    uVar = null;
                }
            }
            if (uVar != null) {
                uVar.c(this.f18269d.schedule(new w(uVar), this.f18272g.f18965b, TimeUnit.NANOSECONDS));
            }
        }
        f0(c0VarD0);
    }

    public final void g0() {
        Future<?> future;
        synchronized (this.f18274i) {
            u uVar = this.f18288w;
            future = null;
            if (uVar != null) {
                Future<?> futureB = uVar.b();
                this.f18288w = null;
                future = futureB;
            }
            this.f18280o = this.f18280o.d();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    @Override // xb.r
    public final void h(vb.w wVar) {
        e0(new f(wVar));
    }

    public final boolean h0(a0 a0Var) {
        return a0Var.f18298f == null && a0Var.f18297e < this.f18272g.f18964a && !a0Var.f18300h;
    }

    @Override // xb.r
    public final void i(String str) {
        e0(new b(str));
    }

    public abstract xb.r i0(vb.a1 a1Var, vb.k.a aVar, int i10, boolean z10);

    @Override // xb.r
    public final void j() {
        e0(new i());
    }

    public abstract void j0();

    @Override // xb.p2
    public final void k(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    public abstract vb.l1 k0();

    @Override // xb.p2
    public void l() {
        e0(new l());
    }

    public final void l0(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            g0();
            return;
        }
        synchronized (this.f18274i) {
            u uVar = this.f18288w;
            if (uVar == null) {
                return;
            }
            Future<?> futureB = uVar.b();
            u uVar2 = new u(this.f18274i);
            this.f18288w = uVar2;
            if (futureB != null) {
                futureB.cancel(false);
            }
            uVar2.c(this.f18269d.schedule(new w(uVar2), num.intValue(), TimeUnit.MILLISECONDS));
        }
    }

    public final void m0(vb.l1 l1Var, xb.s.a aVar, vb.a1 a1Var) {
        this.f18284s = new y(l1Var, aVar, a1Var);
        if (this.f18283r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.f18268c.execute(new q(l1Var, aVar, a1Var));
        }
    }

    @Override // xb.r
    public void n(x0 x0Var) {
        a0 a0Var;
        x0 x0Var2;
        String str;
        synchronized (this.f18274i) {
            x0Var.b("closed", this.f18279n);
            a0Var = this.f18280o;
        }
        if (a0Var.f18298f != null) {
            x0Var2 = new x0();
            a0Var.f18298f.f18321a.n(x0Var2);
            str = "committed";
        } else {
            x0Var2 = new x0();
            for (c0 c0Var : a0Var.f18295c) {
                x0 x0Var3 = new x0();
                c0Var.f18321a.n(x0Var3);
                x0Var2.a(x0Var3);
            }
            str = "open";
        }
        x0Var.b(str, x0Var2);
    }

    public final void n0(ReqT reqt) {
        a0 a0Var = this.f18280o;
        if (a0Var.f18293a) {
            a0Var.f18298f.f18321a.k(this.f18266a.j(reqt));
        } else {
            e0(new n(reqt));
        }
    }

    @Override // xb.r
    public final void o(vb.u uVar) {
        e0(new e(uVar));
    }

    public final vb.a1 o0(vb.a1 a1Var, int i10) {
        vb.a1 a1Var2 = new vb.a1();
        a1Var2.m(a1Var);
        if (i10 > 0) {
            a1Var2.p(A, String.valueOf(i10));
        }
        return a1Var2;
    }

    @Override // xb.r
    public final void p(boolean z10) {
        e0(new h(z10));
    }
}
