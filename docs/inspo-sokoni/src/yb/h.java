package yb;

import java.io.EOFException;
import java.util.List;
import vb.a1;
import vb.b1;
import vb.l1;
import xb.o2;
import xb.u0;
import xb.u2;
import xb.v2;

/* JADX INFO: loaded from: classes2.dex */
public class h extends xb.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final oe.d f19556p = new oe.d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b1<?, ?> f19557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f19558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o2 f19559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f19560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f19561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f19562m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final vb.a f19563n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19564o;

    public class a implements xb.a.b {
        public a() {
        }

        @Override // xb.a.b
        public void a(l1 l1Var) {
            fc.e eVarH = fc.c.h("OkHttpClientStream$Sink.cancel");
            try {
                synchronized (h.this.f19561l.f19567z) {
                    try {
                        h.this.f19561l.a0(l1Var, true, null);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th2) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0063 */
        @Override // xb.a.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(a1 a1Var, byte[] bArr) {
            fc.e eVarH = fc.c.h("OkHttpClientStream$Sink.writeHeaders");
            String str = "/" + h.this.f19557h.c();
            if (bArr != null) {
                h.this.f19564o = true;
                str = str + "?" + l6.a.a().e(bArr);
            }
            synchronized (h.this.f19561l.f19567z) {
                try {
                    h.this.f19561l.g0(a1Var, str);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (eVarH != null) {
                eVarH.close();
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0046 */
        @Override // xb.a.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(v2 v2Var, boolean z10, boolean z11, int i10) {
            oe.d dVarD;
            fc.e eVarH = fc.c.h("OkHttpClientStream$Sink.writeFrame");
            if (v2Var == null) {
                dVarD = h.f19556p;
            } else {
                dVarD = ((p) v2Var).d();
                int size = (int) dVarD.size();
                if (size > 0) {
                    h.this.s(size);
                }
            }
            synchronized (h.this.f19561l.f19567z) {
                try {
                    h.this.f19561l.e0(dVarD, z10, z11);
                    h.this.w().e(i10);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (eVarH != null) {
                eVarH.close();
            }
        }
    }

    public class b extends u0 implements r.b {
        public List<ac.d> A;
        public oe.d B;
        public boolean C;
        public boolean D;
        public boolean E;
        public int F;
        public int G;
        public final yb.b H;
        public final r I;
        public final i J;
        public boolean K;
        public final fc.d L;
        public r.c M;
        public int N;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f19566y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final Object f19567z;

        public b(int i10, o2 o2Var, Object obj, yb.b bVar, r rVar, i iVar, int i11, String str) {
            super(i10, o2Var, h.this.w());
            this.B = new oe.d();
            this.C = false;
            this.D = false;
            this.E = false;
            this.K = true;
            this.N = -1;
            this.f19567z = j6.m.p(obj, "lock");
            this.H = bVar;
            this.I = rVar;
            this.J = iVar;
            this.F = i11;
            this.G = i11;
            this.f19566y = i11;
            this.L = fc.c.b(str);
        }

        @Override // xb.u0
        public void P(l1 l1Var, boolean z10, a1 a1Var) throws EOFException {
            a0(l1Var, z10, a1Var);
        }

        public final void a0(l1 l1Var, boolean z10, a1 a1Var) throws EOFException {
            if (this.E) {
                return;
            }
            this.E = true;
            if (!this.K) {
                this.J.U(c0(), l1Var, xb.s.a.PROCESSED, z10, ac.a.CANCEL, a1Var);
                return;
            }
            this.J.g0(h.this);
            this.A = null;
            this.B.t();
            this.K = false;
            if (a1Var == null) {
                a1Var = new a1();
            }
            N(l1Var, true, a1Var);
        }

        public r.c b0() {
            r.c cVar;
            synchronized (this.f19567z) {
                cVar = this.M;
            }
            return cVar;
        }

        @Override // xb.u0, xb.a.c, xb.l1.b
        public void c(boolean z10) {
            d0();
            super.c(z10);
        }

        public int c0() {
            return this.N;
        }

        @Override // xb.l1.b
        public void d(int i10) {
            int i11 = this.G - i10;
            this.G = i11;
            float f10 = i11;
            int i12 = this.f19566y;
            if (f10 <= i12 * 0.5f) {
                int i13 = i12 - i11;
                this.F += i13;
                this.G = i11 + i13;
                this.H.c(c0(), i13);
            }
        }

        public final void d0() {
            if (G()) {
                this.J.U(c0(), null, xb.s.a.PROCESSED, false, null, null);
            } else {
                this.J.U(c0(), null, xb.s.a.PROCESSED, false, ac.a.CANCEL, null);
            }
        }

        @Override // xb.l1.b
        public void e(Throwable th) throws EOFException {
            P(l1.k(th), true, new a1());
        }

        public final void e0(oe.d dVar, boolean z10, boolean z11) {
            if (this.E) {
                return;
            }
            if (!this.K) {
                j6.m.v(c0() != -1, "streamId should be set");
                this.I.d(z10, this.M, dVar, z11);
            } else {
                this.B.X(dVar, (int) dVar.size());
                this.C |= z10;
                this.D |= z11;
            }
        }

        @Override // xb.f.d
        public void f(Runnable runnable) {
            synchronized (this.f19567z) {
                runnable.run();
            }
        }

        public void f0(int i10) {
            j6.m.w(this.N == -1, "the stream has been started with id %s", i10);
            this.N = i10;
            this.M = this.I.c(this, i10);
            h.this.f19561l.r();
            if (this.K) {
                this.H.U(h.this.f19564o, false, this.N, 0, this.A);
                h.this.f19559j.c();
                this.A = null;
                if (this.B.size() > 0) {
                    this.I.d(this.C, this.M, this.B, this.D);
                }
                this.K = false;
            }
        }

        public final void g0(a1 a1Var, String str) {
            this.A = d.b(a1Var, str, h.this.f19560k, h.this.f19558i, h.this.f19564o, this.J.a0());
            this.J.n0(h.this);
        }

        public fc.d h0() {
            return this.L;
        }

        public void i0(oe.d dVar, boolean z10, int i10) throws Throwable {
            int size = this.F - (((int) dVar.size()) + i10);
            this.F = size;
            this.G -= i10;
            if (size >= 0) {
                super.S(new l(dVar), z10);
            } else {
                this.H.b(c0(), ac.a.FLOW_CONTROL_ERROR);
                this.J.U(c0(), l1.f17419s.q("Received data size exceeded our receiving window size"), xb.s.a.PROCESSED, false, null, null);
            }
        }

        public void j0(List<ac.d> list, boolean z10) {
            if (z10) {
                U(s.c(list));
            } else {
                T(s.a(list));
            }
        }

        @Override // xb.c.a
        public void r() {
            super.r();
            m().c();
        }
    }

    public h(b1<?, ?> b1Var, a1 a1Var, yb.b bVar, i iVar, r rVar, Object obj, int i10, int i11, String str, String str2, o2 o2Var, u2 u2Var, vb.c cVar, boolean z10) {
        super(new q(), o2Var, u2Var, a1Var, cVar, z10 && b1Var.f());
        this.f19562m = new a();
        this.f19564o = false;
        this.f19559j = (o2) j6.m.p(o2Var, "statsTraceCtx");
        this.f19557h = b1Var;
        this.f19560k = str;
        this.f19558i = str2;
        this.f19563n = iVar.getAttributes();
        this.f19561l = new b(i10, o2Var, obj, bVar, rVar, iVar, i11, b1Var.c());
    }

    public b1.d L() {
        return this.f19557h.e();
    }

    @Override // xb.a
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public b t() {
        return this.f19561l;
    }

    public boolean N() {
        return this.f19564o;
    }

    @Override // xb.r
    public vb.a getAttributes() {
        return this.f19563n;
    }

    @Override // xb.r
    public void i(String str) {
        this.f19560k = (String) j6.m.p(str, "authority");
    }

    @Override // xb.a
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public a u() {
        return this.f19562m;
    }
}
