package u4;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class h6 {
    public Long A;
    public Long B;
    public long C;
    public String D;
    public int E;
    public int F;
    public long G;
    public String H;
    public byte[] I;
    public int J;
    public long K;
    public long L;
    public long M;
    public long N;
    public long O;
    public long P;
    public String Q;
    public boolean R;
    public long S;
    public long T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k7 f16278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f16284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f16285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f16286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f16287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f16288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f16289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f16290m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f16291n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f16292o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f16293p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f16294q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f16295r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f16296s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<String> f16297t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f16298u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f16299v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f16300w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f16301x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f16302y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f16303z;

    public h6(k7 k7Var, String str) {
        com.google.android.gms.common.internal.r.l(k7Var);
        com.google.android.gms.common.internal.r.f(str);
        this.f16278a = k7Var;
        this.f16279b = str;
        k7Var.zzl().j();
    }

    public final boolean A() {
        this.f16278a.zzl().j();
        return this.f16292o;
    }

    public final long A0() {
        this.f16278a.zzl().j();
        return this.f16290m;
    }

    public final boolean B() {
        this.f16278a.zzl().j();
        return this.R;
    }

    public final void B0(long j10) {
        com.google.android.gms.common.internal.r.a(j10 >= 0);
        this.f16278a.zzl().j();
        this.R |= this.f16284g != j10;
        this.f16284g = j10;
    }

    public final boolean C() {
        this.f16278a.zzl().j();
        return this.f16299v;
    }

    public final long C0() {
        this.f16278a.zzl().j();
        return this.G;
    }

    public final boolean D() {
        this.f16278a.zzl().j();
        return this.f16303z;
    }

    public final void D0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.f16285h != j10;
        this.f16285h = j10;
    }

    public final byte[] E() {
        this.f16278a.zzl().j();
        return this.I;
    }

    public final long E0() {
        this.f16278a.zzl().j();
        return this.f16286i;
    }

    public final int F() {
        this.f16278a.zzl().j();
        return this.J;
    }

    public final void F0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.f16301x != j10;
        this.f16301x = j10;
    }

    public final void G(int i10) {
        this.f16278a.zzl().j();
        this.R |= this.J != i10;
        this.J = i10;
    }

    public final long G0() {
        this.f16278a.zzl().j();
        return this.f16284g;
    }

    public final void H(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.f16288k != j10;
        this.f16288k = j10;
    }

    public final void H0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.f16300w != j10;
        this.f16300w = j10;
    }

    public final void I(Long l10) {
        this.f16278a.zzl().j();
        this.R |= !Objects.equals(this.B, l10);
        this.B = l10;
    }

    public final long I0() {
        this.f16278a.zzl().j();
        return this.f16285h;
    }

    public final void J(String str) {
        this.f16278a.zzl().j();
        this.R |= !Objects.equals(this.f16280c, str);
        this.f16280c = str;
    }

    public final long J0() {
        this.f16278a.zzl().j();
        return this.f16301x;
    }

    public final void K(boolean z10) {
        this.f16278a.zzl().j();
        this.R |= this.f16292o != z10;
        this.f16292o = z10;
    }

    public final long K0() {
        this.f16278a.zzl().j();
        return this.f16300w;
    }

    public final int L() {
        this.f16278a.zzl().j();
        return this.F;
    }

    public final Boolean L0() {
        this.f16278a.zzl().j();
        return this.f16295r;
    }

    public final void M(int i10) {
        this.f16278a.zzl().j();
        this.R |= this.F != i10;
        this.F = i10;
    }

    public final Long M0() {
        this.f16278a.zzl().j();
        return this.A;
    }

    public final void N(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.C != j10;
        this.C = j10;
    }

    public final Long N0() {
        this.f16278a.zzl().j();
        return this.B;
    }

    public final void O(String str) {
        this.f16278a.zzl().j();
        this.R |= !Objects.equals(this.f16289l, str);
        this.f16289l = str;
    }

    public final void P(boolean z10) {
        this.f16278a.zzl().j();
        this.R |= this.f16299v != z10;
        this.f16299v = z10;
    }

    public final int Q() {
        this.f16278a.zzl().j();
        return this.E;
    }

    public final void R(int i10) {
        this.f16278a.zzl().j();
        this.R |= this.E != i10;
        this.E = i10;
    }

    public final void S(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.S != j10;
        this.S = j10;
    }

    public final void T(String str) {
        this.f16278a.zzl().j();
        this.R |= !Objects.equals(this.f16287j, str);
        this.f16287j = str;
    }

    public final void U(boolean z10) {
        this.f16278a.zzl().j();
        this.R |= this.f16303z != z10;
        this.f16303z = z10;
    }

    public final long V() {
        this.f16278a.zzl().j();
        return this.f16288k;
    }

    public final void W(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.N != j10;
        this.N = j10;
    }

    public final void X(String str) {
        this.f16278a.zzl().j();
        this.R |= !Objects.equals(this.f16283f, str);
        this.f16283f = str;
    }

    public final long Y() {
        this.f16278a.zzl().j();
        return this.C;
    }

    public final void Z(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.O != j10;
        this.O = j10;
    }

    public final int a() {
        this.f16278a.zzl().j();
        return this.f16302y;
    }

    public final void a0(String str) {
        this.f16278a.zzl().j();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.R |= !Objects.equals(this.f16281d, str);
        this.f16281d = str;
    }

    public final void b(int i10) {
        this.f16278a.zzl().j();
        this.R |= this.f16302y != i10;
        this.f16302y = i10;
    }

    public final long b0() {
        this.f16278a.zzl().j();
        return this.S;
    }

    public final void c(long j10) {
        this.f16278a.zzl().j();
        long j11 = this.f16284g + j10;
        if (j11 > 2147483647L) {
            this.f16278a.zzj().H().b("Bundle index overflow. appId", v5.r(this.f16279b));
            j11 = j10 - 1;
        }
        long j12 = this.G + 1;
        if (j12 > 2147483647L) {
            this.f16278a.zzj().H().b("Delivery index overflow. appId", v5.r(this.f16279b));
            j12 = 0;
        }
        this.R = true;
        this.f16284g = j11;
        this.G = j12;
    }

    public final void c0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.M != j10;
        this.M = j10;
    }

    public final void d(Boolean bool) {
        this.f16278a.zzl().j();
        this.R |= !Objects.equals(this.f16295r, bool);
        this.f16295r = bool;
    }

    public final void d0(String str) {
        this.f16278a.zzl().j();
        this.R |= !Objects.equals(this.Q, str);
        this.Q = str;
    }

    public final void e(Long l10) {
        this.f16278a.zzl().j();
        this.R |= !Objects.equals(this.A, l10);
        this.A = l10;
    }

    public final long e0() {
        this.f16278a.zzl().j();
        return this.N;
    }

    public final void f(String str) {
        this.f16278a.zzl().j();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.R |= !Objects.equals(this.f16294q, str);
        this.f16294q = str;
    }

    public final void f0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.L != j10;
        this.L = j10;
    }

    public final void g(List<String> list) {
        this.f16278a.zzl().j();
        if (Objects.equals(this.f16297t, list)) {
            return;
        }
        this.R = true;
        this.f16297t = list != null ? new ArrayList(list) : null;
    }

    public final void g0(String str) {
        this.f16278a.zzl().j();
        this.R |= !Objects.equals(this.f16282e, str);
        this.f16282e = str;
    }

    public final void h(boolean z10) {
        this.f16278a.zzl().j();
        this.R |= this.f16293p != z10;
        this.f16293p = z10;
    }

    public final long h0() {
        this.f16278a.zzl().j();
        return this.O;
    }

    public final void i(byte[] bArr) {
        this.f16278a.zzl().j();
        this.R |= this.I != bArr;
        this.I = bArr;
    }

    public final void i0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.P != j10;
        this.P = j10;
    }

    public final String j() {
        this.f16278a.zzl().j();
        return this.f16294q;
    }

    public final void j0(String str) {
        this.f16278a.zzl().j();
        this.R |= this.H != str;
        this.H = str;
    }

    public final String k() {
        this.f16278a.zzl().j();
        String str = this.Q;
        d0(null);
        return str;
    }

    public final long k0() {
        this.f16278a.zzl().j();
        return this.M;
    }

    public final String l() {
        this.f16278a.zzl().j();
        return this.f16279b;
    }

    public final void l0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.K != j10;
        this.K = j10;
    }

    public final String m() {
        this.f16278a.zzl().j();
        return this.f16280c;
    }

    public final void m0(String str) {
        this.f16278a.zzl().j();
        this.R |= !Objects.equals(this.f16298u, str);
        this.f16298u = str;
    }

    public final String n() {
        this.f16278a.zzl().j();
        return this.f16289l;
    }

    public final long n0() {
        this.f16278a.zzl().j();
        return this.L;
    }

    public final String o() {
        this.f16278a.zzl().j();
        return this.f16287j;
    }

    public final void o0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.f16291n != j10;
        this.f16291n = j10;
    }

    public final String p() {
        this.f16278a.zzl().j();
        return this.f16283f;
    }

    public final void p0(String str) {
        this.f16278a.zzl().j();
        this.R |= this.D != str;
        this.D = str;
    }

    public final String q() {
        this.f16278a.zzl().j();
        return this.f16281d;
    }

    public final long q0() {
        this.f16278a.zzl().j();
        return this.P;
    }

    public final String r() {
        this.f16278a.zzl().j();
        return this.Q;
    }

    public final void r0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.f16296s != j10;
        this.f16296s = j10;
    }

    public final String s() {
        this.f16278a.zzl().j();
        return this.f16282e;
    }

    public final long s0() {
        this.f16278a.zzl().j();
        return this.K;
    }

    public final String t() {
        this.f16278a.zzl().j();
        return this.H;
    }

    public final void t0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.T != j10;
        this.T = j10;
    }

    public final String u() {
        this.f16278a.zzl().j();
        return this.f16298u;
    }

    public final long u0() {
        this.f16278a.zzl().j();
        return this.f16291n;
    }

    public final String v() {
        this.f16278a.zzl().j();
        return this.D;
    }

    public final void v0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.f16290m != j10;
        this.f16290m = j10;
    }

    public final List<String> w() {
        this.f16278a.zzl().j();
        return this.f16297t;
    }

    public final long w0() {
        this.f16278a.zzl().j();
        return this.f16296s;
    }

    public final void x() {
        this.f16278a.zzl().j();
        this.R = false;
    }

    public final void x0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.G != j10;
        this.G = j10;
    }

    public final void y() {
        this.f16278a.zzl().j();
        long j10 = this.f16284g + 1;
        if (j10 > 2147483647L) {
            this.f16278a.zzj().H().b("Bundle index overflow. appId", v5.r(this.f16279b));
            j10 = 0;
        }
        this.R = true;
        this.f16284g = j10;
    }

    public final long y0() {
        this.f16278a.zzl().j();
        return this.T;
    }

    public final boolean z() {
        this.f16278a.zzl().j();
        return this.f16293p;
    }

    public final void z0(long j10) {
        this.f16278a.zzl().j();
        this.R |= this.f16286i != j10;
        this.f16286i = j10;
    }
}
