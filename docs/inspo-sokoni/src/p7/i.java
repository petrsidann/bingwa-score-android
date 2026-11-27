package p7;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzagw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i extends o7.a0 {
    public static final Parcelable.Creator<i> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzagw f14242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f14243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<e> f14246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f14247f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f14248l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Boolean f14249m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public k f14250n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14251o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public o7.x1 f14252p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public n0 f14253q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<o7.m1> f14254r;

    public i(zzagw zzagwVar, e eVar, String str, String str2, List<e> list, List<String> list2, String str3, Boolean bool, k kVar, boolean z10, o7.x1 x1Var, n0 n0Var, List<o7.m1> list3) {
        this.f14242a = zzagwVar;
        this.f14243b = eVar;
        this.f14244c = str;
        this.f14245d = str2;
        this.f14246e = list;
        this.f14247f = list2;
        this.f14248l = str3;
        this.f14249m = bool;
        this.f14250n = kVar;
        this.f14251o = z10;
        this.f14252p = x1Var;
        this.f14253q = n0Var;
        this.f14254r = list3;
    }

    public i(h7.f fVar, List<? extends o7.b1> list) {
        com.google.android.gms.common.internal.r.l(fVar);
        this.f14244c = fVar.q();
        this.f14245d = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.f14248l = "2";
        o0(list);
    }

    public final List<o7.j0> A0() {
        n0 n0Var = this.f14253q;
        return n0Var != null ? n0Var.zza() : new ArrayList();
    }

    public final List<e> B0() {
        return this.f14246e;
    }

    public final boolean C0() {
        return this.f14251o;
    }

    @Override // o7.a0, o7.b1
    public String P() {
        return this.f14243b.P();
    }

    @Override // o7.a0
    public o7.b0 U() {
        return this.f14250n;
    }

    @Override // o7.a0
    public /* synthetic */ o7.h0 V() {
        return new m(this);
    }

    @Override // o7.a0
    public List<? extends o7.b1> W() {
        return this.f14246e;
    }

    @Override // o7.a0
    public String X() {
        Map map;
        zzagw zzagwVar = this.f14242a;
        if (zzagwVar == null || zzagwVar.zzc() == null || (map = (Map) m0.a(this.f14242a.zzc()).b().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // o7.a0
    public boolean Y() {
        o7.c0 c0VarA;
        Boolean bool = this.f14249m;
        if (bool == null || bool.booleanValue()) {
            zzagw zzagwVar = this.f14242a;
            String strE = "";
            if (zzagwVar != null && (c0VarA = m0.a(zzagwVar.zzc())) != null) {
                strE = c0VarA.e();
            }
            boolean z10 = true;
            if (W().size() > 1 || (strE != null && strE.equals("custom"))) {
                z10 = false;
            }
            this.f14249m = Boolean.valueOf(z10);
        }
        return this.f14249m.booleanValue();
    }

    @Override // o7.a0, o7.b1
    public String h() {
        return this.f14243b.h();
    }

    @Override // o7.b1
    public String i() {
        return this.f14243b.i();
    }

    @Override // o7.a0, o7.b1
    public Uri j() {
        return this.f14243b.j();
    }

    @Override // o7.b1
    public boolean n() {
        return this.f14243b.n();
    }

    @Override // o7.a0
    public final h7.f n0() {
        return h7.f.p(this.f14244c);
    }

    @Override // o7.a0
    public final synchronized o7.a0 o0(List<? extends o7.b1> list) {
        com.google.android.gms.common.internal.r.l(list);
        this.f14246e = new ArrayList(list.size());
        this.f14247f = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            o7.b1 b1Var = list.get(i10);
            if (b1Var.i().equals("firebase")) {
                this.f14243b = (e) b1Var;
            } else {
                this.f14247f.add(b1Var.i());
            }
            this.f14246e.add((e) b1Var);
        }
        if (this.f14243b == null) {
            this.f14243b = this.f14246e.get(0);
        }
        return this;
    }

    @Override // o7.a0
    public final void p0(zzagw zzagwVar) {
        this.f14242a = (zzagw) com.google.android.gms.common.internal.r.l(zzagwVar);
    }

    @Override // o7.a0
    public final /* synthetic */ o7.a0 q0() {
        this.f14249m = Boolean.FALSE;
        return this;
    }

    @Override // o7.a0, o7.b1
    public String r() {
        return this.f14243b.r();
    }

    @Override // o7.a0
    public final void r0(List<o7.m1> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f14254r = list;
    }

    @Override // o7.a0
    public final zzagw s0() {
        return this.f14242a;
    }

    @Override // o7.a0
    public final void t0(List<o7.j0> list) {
        this.f14253q = n0.S(list);
    }

    @Override // o7.a0
    public final List<o7.m1> u0() {
        return this.f14254r;
    }

    public final i v0(String str) {
        this.f14248l = str;
        return this;
    }

    @Override // o7.a0, o7.b1
    public String w() {
        return this.f14243b.w();
    }

    public final void w0(o7.x1 x1Var) {
        this.f14252p = x1Var;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 1, s0(), i10, false);
        d4.c.C(parcel, 2, this.f14243b, i10, false);
        d4.c.E(parcel, 3, this.f14244c, false);
        d4.c.E(parcel, 4, this.f14245d, false);
        d4.c.I(parcel, 5, this.f14246e, false);
        d4.c.G(parcel, 6, zzg(), false);
        d4.c.E(parcel, 7, this.f14248l, false);
        d4.c.i(parcel, 8, Boolean.valueOf(Y()), false);
        d4.c.C(parcel, 9, U(), i10, false);
        d4.c.g(parcel, 10, this.f14251o);
        d4.c.C(parcel, 11, this.f14252p, i10, false);
        d4.c.C(parcel, 12, this.f14253q, i10, false);
        d4.c.I(parcel, 13, u0(), false);
        d4.c.b(parcel, iA);
    }

    public final void x0(k kVar) {
        this.f14250n = kVar;
    }

    public final void y0(boolean z10) {
        this.f14251o = z10;
    }

    public final o7.x1 z0() {
        return this.f14252p;
    }

    @Override // o7.a0
    public final String zzd() {
        return s0().zzc();
    }

    @Override // o7.a0
    public final String zze() {
        return this.f14242a.zzf();
    }

    @Override // o7.a0
    public final List<String> zzg() {
        return this.f14247f;
    }
}
