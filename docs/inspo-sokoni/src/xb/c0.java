package xb;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c0 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f18197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f18198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f18199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vb.l1 f18200d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f18202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f18203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f18204h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Runnable> f18201e = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<Runnable> f18205i = new ArrayList();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18206a;

        public a(int i10) {
            this.f18206a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.d(this.f18206a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.l();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.o f18209a;

        public c(vb.o oVar) {
            this.f18209a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.b(this.f18209a);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18211a;

        public d(boolean z10) {
            this.f18211a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.p(this.f18211a);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.w f18213a;

        public e(vb.w wVar) {
            this.f18213a = wVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.h(this.f18213a);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18215a;

        public f(int i10) {
            this.f18215a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.e(this.f18215a);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18217a;

        public g(int i10) {
            this.f18217a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.f(this.f18217a);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.u f18219a;

        public h(vb.u uVar) {
            this.f18219a = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.o(this.f18219a);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.s();
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18222a;

        public j(String str) {
            this.f18222a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.i(this.f18222a);
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f18224a;

        public k(InputStream inputStream) {
            this.f18224a = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.k(this.f18224a);
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.flush();
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.l1 f18227a;

        public m(vb.l1 l1Var) {
            this.f18227a = l1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.a(this.f18227a);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18199c.j();
        }
    }

    public static class o implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f18230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f18231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Runnable> f18232c = new ArrayList();

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q2.a f18233a;

            public a(q2.a aVar) {
                this.f18233a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f18230a.a(this.f18233a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f18230a.b();
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.a1 f18236a;

            public c(vb.a1 a1Var) {
                this.f18236a = a1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f18230a.d(this.f18236a);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.l1 f18238a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s.a f18239b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ vb.a1 f18240c;

            public d(vb.l1 l1Var, s.a aVar, vb.a1 a1Var) {
                this.f18238a = l1Var;
                this.f18239b = aVar;
                this.f18240c = a1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f18230a.c(this.f18238a, this.f18239b, this.f18240c);
            }
        }

        public o(s sVar) {
            this.f18230a = sVar;
        }

        @Override // xb.q2
        public void a(q2.a aVar) {
            if (this.f18231b) {
                this.f18230a.a(aVar);
            } else {
                f(new a(aVar));
            }
        }

        @Override // xb.q2
        public void b() {
            if (this.f18231b) {
                this.f18230a.b();
            } else {
                f(new b());
            }
        }

        @Override // xb.s
        public void c(vb.l1 l1Var, s.a aVar, vb.a1 a1Var) {
            f(new d(l1Var, aVar, a1Var));
        }

        @Override // xb.s
        public void d(vb.a1 a1Var) {
            f(new c(a1Var));
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                if (this.f18231b) {
                    runnable.run();
                } else {
                    this.f18232c.add(runnable);
                }
            }
        }

        public void g() {
            List<Runnable> list;
            List<Runnable> arrayList = new ArrayList<>();
            while (true) {
                synchronized (this) {
                    if (this.f18232c.isEmpty()) {
                        this.f18232c = null;
                        this.f18231b = true;
                        return;
                    } else {
                        list = this.f18232c;
                        this.f18232c = arrayList;
                    }
                }
                Iterator<Runnable> it = list.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                list.clear();
                arrayList = list;
            }
        }
    }

    @Override // xb.r
    public void a(vb.l1 l1Var) {
        boolean z10 = true;
        j6.m.v(this.f18198b != null, "May only be called after start");
        j6.m.p(l1Var, "reason");
        synchronized (this) {
            if (this.f18199c == null) {
                v(o1.f18784a);
                this.f18200d = l1Var;
                z10 = false;
            }
        }
        if (z10) {
            r(new m(l1Var));
            return;
        }
        s();
        u(l1Var);
        this.f18198b.c(l1Var, s.a.PROCESSED, new vb.a1());
    }

    @Override // xb.p2
    public void b(vb.o oVar) {
        j6.m.v(this.f18198b == null, "May only be called before start");
        j6.m.p(oVar, "compressor");
        this.f18205i.add(new c(oVar));
    }

    @Override // xb.p2
    public boolean c() {
        if (this.f18197a) {
            return this.f18199c.c();
        }
        return false;
    }

    @Override // xb.p2
    public void d(int i10) {
        j6.m.v(this.f18198b != null, "May only be called after start");
        if (this.f18197a) {
            this.f18199c.d(i10);
        } else {
            r(new a(i10));
        }
    }

    @Override // xb.r
    public void e(int i10) {
        j6.m.v(this.f18198b == null, "May only be called before start");
        this.f18205i.add(new f(i10));
    }

    @Override // xb.r
    public void f(int i10) {
        j6.m.v(this.f18198b == null, "May only be called before start");
        this.f18205i.add(new g(i10));
    }

    @Override // xb.p2
    public void flush() {
        j6.m.v(this.f18198b != null, "May only be called after start");
        if (this.f18197a) {
            this.f18199c.flush();
        } else {
            r(new l());
        }
    }

    @Override // xb.r
    public void g(s sVar) {
        vb.l1 l1Var;
        boolean z10;
        j6.m.p(sVar, "listener");
        j6.m.v(this.f18198b == null, "already started");
        synchronized (this) {
            l1Var = this.f18200d;
            z10 = this.f18197a;
            if (!z10) {
                o oVar = new o(sVar);
                this.f18202f = oVar;
                sVar = oVar;
            }
            this.f18198b = sVar;
            this.f18203g = System.nanoTime();
        }
        if (l1Var != null) {
            sVar.c(l1Var, s.a.PROCESSED, new vb.a1());
        } else if (z10) {
            t(sVar);
        }
    }

    @Override // xb.r
    public void h(vb.w wVar) {
        j6.m.v(this.f18198b == null, "May only be called before start");
        j6.m.p(wVar, "decompressorRegistry");
        this.f18205i.add(new e(wVar));
    }

    @Override // xb.r
    public void i(String str) {
        j6.m.v(this.f18198b == null, "May only be called before start");
        j6.m.p(str, "authority");
        this.f18205i.add(new j(str));
    }

    @Override // xb.r
    public void j() {
        j6.m.v(this.f18198b != null, "May only be called after start");
        r(new n());
    }

    @Override // xb.p2
    public void k(InputStream inputStream) {
        j6.m.v(this.f18198b != null, "May only be called after start");
        j6.m.p(inputStream, "message");
        if (this.f18197a) {
            this.f18199c.k(inputStream);
        } else {
            r(new k(inputStream));
        }
    }

    @Override // xb.p2
    public void l() {
        j6.m.v(this.f18198b == null, "May only be called before start");
        this.f18205i.add(new b());
    }

    @Override // xb.r
    public void n(x0 x0Var) {
        synchronized (this) {
            if (this.f18198b == null) {
                return;
            }
            if (this.f18199c != null) {
                x0Var.b("buffered_nanos", Long.valueOf(this.f18204h - this.f18203g));
                this.f18199c.n(x0Var);
            } else {
                x0Var.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f18203g));
                x0Var.a("waiting_for_connection");
            }
        }
    }

    @Override // xb.r
    public void o(vb.u uVar) {
        j6.m.v(this.f18198b == null, "May only be called before start");
        this.f18205i.add(new h(uVar));
    }

    @Override // xb.r
    public void p(boolean z10) {
        j6.m.v(this.f18198b == null, "May only be called before start");
        this.f18205i.add(new d(z10));
    }

    public final void r(Runnable runnable) {
        j6.m.v(this.f18198b != null, "May only be called after start");
        synchronized (this) {
            if (this.f18197a) {
                runnable.run();
            } else {
                this.f18201e.add(runnable);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r0.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r0.next().run();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s() {
        o oVar;
        List<Runnable> list;
        List<Runnable> arrayList = new ArrayList<>();
        while (true) {
            synchronized (this) {
                if (this.f18201e.isEmpty()) {
                    break;
                }
                list = this.f18201e;
                this.f18201e = arrayList;
            }
            if (oVar != null) {
                oVar.g();
            }
            list.clear();
            arrayList = list;
        }
        this.f18201e = null;
        this.f18197a = true;
        oVar = this.f18202f;
        if (oVar != null) {
            oVar.g();
        }
    }

    public final void t(s sVar) {
        Iterator<Runnable> it = this.f18205i.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.f18205i = null;
        this.f18199c.g(sVar);
    }

    public void u(vb.l1 l1Var) {
    }

    public final void v(r rVar) {
        r rVar2 = this.f18199c;
        j6.m.x(rVar2 == null, "realStream already set to %s", rVar2);
        this.f18199c = rVar;
        this.f18204h = System.nanoTime();
    }

    public final Runnable w(r rVar) {
        synchronized (this) {
            if (this.f18199c != null) {
                return null;
            }
            v((r) j6.m.p(rVar, "stream"));
            s sVar = this.f18198b;
            if (sVar == null) {
                this.f18201e = null;
                this.f18197a = true;
            }
            if (sVar == null) {
                return null;
            }
            t(sVar);
            return new i();
        }
    }
}
