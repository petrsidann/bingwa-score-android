package yb;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f19640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ac.c f19641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19642c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f19643d = new c(0, 65535, null);

    public interface b {
        void b(int i10);
    }

    public final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f19645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19648e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f19649f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final oe.d f19644a = new oe.d();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f19650g = false;

        public c(int i10, int i11, b bVar) {
            this.f19646c = i10;
            this.f19647d = i11;
            this.f19649f = bVar;
        }

        public void a(int i10) {
            this.f19648e += i10;
        }

        public int b() {
            return this.f19648e;
        }

        public void c() {
            this.f19648e = 0;
        }

        public void d(oe.d dVar, int i10, boolean z10) {
            this.f19644a.X(dVar, i10);
            this.f19650g |= z10;
        }

        public boolean e() {
            return this.f19644a.size() > 0;
        }

        public int f(int i10) {
            if (i10 <= 0 || com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER - i10 >= this.f19647d) {
                int i11 = this.f19647d + i10;
                this.f19647d = i11;
                return i11;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.f19646c);
        }

        public int g() {
            return Math.max(0, Math.min(this.f19647d, (int) this.f19644a.size()));
        }

        public int h() {
            return g() - this.f19648e;
        }

        public int i() {
            return this.f19647d;
        }

        public int j() {
            return Math.min(this.f19647d, r.this.f19643d.i());
        }

        public void k(oe.d dVar, int i10, boolean z10) {
            do {
                int iMin = Math.min(i10, r.this.f19641b.T());
                int i11 = -iMin;
                r.this.f19643d.f(i11);
                f(i11);
                try {
                    r.this.f19641b.M(dVar.size() == ((long) iMin) && z10, this.f19646c, dVar, iMin);
                    this.f19649f.b(iMin);
                    i10 -= iMin;
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            } while (i10 > 0);
        }

        public int l(int i10, e eVar) {
            Runnable runnable;
            int iMin = Math.min(i10, j());
            int size = 0;
            while (e() && iMin > 0) {
                if (iMin >= this.f19644a.size()) {
                    size += (int) this.f19644a.size();
                    oe.d dVar = this.f19644a;
                    k(dVar, (int) dVar.size(), this.f19650g);
                } else {
                    size += iMin;
                    k(this.f19644a, iMin, false);
                }
                eVar.b();
                iMin = Math.min(i10 - size, j());
            }
            if (!e() && (runnable = this.f19645b) != null) {
                runnable.run();
                this.f19645b = null;
            }
            return size;
        }
    }

    public interface d {
        c[] b();
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19652a;

        public e() {
        }

        public boolean a() {
            return this.f19652a > 0;
        }

        public void b() {
            this.f19652a++;
        }
    }

    public r(d dVar, ac.c cVar) {
        this.f19640a = (d) j6.m.p(dVar, "transport");
        this.f19641b = (ac.c) j6.m.p(cVar, "frameWriter");
    }

    public c c(b bVar, int i10) {
        return new c(i10, this.f19642c, (b) j6.m.p(bVar, "stream"));
    }

    public void d(boolean z10, c cVar, oe.d dVar, boolean z11) {
        j6.m.p(dVar, "source");
        int iJ = cVar.j();
        boolean zE = cVar.e();
        int size = (int) dVar.size();
        if (zE || iJ < size) {
            if (!zE && iJ > 0) {
                cVar.k(dVar, iJ, false);
            }
            cVar.d(dVar, (int) dVar.size(), z10);
        } else {
            cVar.k(dVar, size, z10);
        }
        if (z11) {
            e();
        }
    }

    public void e() {
        try {
            this.f19641b.flush();
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public boolean f(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i10);
        }
        int i11 = i10 - this.f19642c;
        this.f19642c = i10;
        for (c cVar : this.f19640a.b()) {
            cVar.f(i11);
        }
        return i11 > 0;
    }

    public int g(c cVar, int i10) {
        if (cVar == null) {
            int iF = this.f19643d.f(i10);
            h();
            return iF;
        }
        int iF2 = cVar.f(i10);
        e eVar = new e();
        cVar.l(cVar.j(), eVar);
        if (eVar.a()) {
            e();
        }
        return iF2;
    }

    public void h() {
        int i10;
        c[] cVarArrB = this.f19640a.b();
        Collections.shuffle(Arrays.asList(cVarArrB));
        int i11 = this.f19643d.i();
        int length = cVarArrB.length;
        while (true) {
            i10 = 0;
            if (length <= 0 || i11 <= 0) {
                break;
            }
            int iCeil = (int) Math.ceil(i11 / length);
            for (int i12 = 0; i12 < length && i11 > 0; i12++) {
                c cVar = cVarArrB[i12];
                int iMin = Math.min(i11, Math.min(cVar.h(), iCeil));
                if (iMin > 0) {
                    cVar.a(iMin);
                    i11 -= iMin;
                }
                if (cVar.h() > 0) {
                    cVarArrB[i10] = cVar;
                    i10++;
                }
            }
            length = i10;
        }
        e eVar = new e();
        c[] cVarArrB2 = this.f19640a.b();
        int length2 = cVarArrB2.length;
        while (i10 < length2) {
            c cVar2 = cVarArrB2[i10];
            cVar2.l(cVar2.b(), eVar);
            cVar2.c();
            i10++;
        }
        if (eVar.a()) {
            e();
        }
    }
}
