package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u extends c0 {
    public static final Parcelable.Creator<u> CREATOR = new t0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f14784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f14785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f14787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Double f14788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f14789f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k f14790l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f14791m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e0 f14792n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f14793o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f14794p;

    public u(y yVar, a0 a0Var, byte[] bArr, List list, Double d10, List list2, k kVar, Integer num, e0 e0Var, String str, d dVar) {
        this.f14784a = (y) com.google.android.gms.common.internal.r.l(yVar);
        this.f14785b = (a0) com.google.android.gms.common.internal.r.l(a0Var);
        this.f14786c = (byte[]) com.google.android.gms.common.internal.r.l(bArr);
        this.f14787d = (List) com.google.android.gms.common.internal.r.l(list);
        this.f14788e = d10;
        this.f14789f = list2;
        this.f14790l = kVar;
        this.f14791m = num;
        this.f14792n = e0Var;
        if (str != null) {
            try {
                this.f14793o = c.d(str);
            } catch (c.a e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            this.f14793o = null;
        }
        this.f14794p = dVar;
    }

    public String S() {
        c cVar = this.f14793o;
        if (cVar == null) {
            return null;
        }
        return cVar.toString();
    }

    public d T() {
        return this.f14794p;
    }

    public k U() {
        return this.f14790l;
    }

    public byte[] V() {
        return this.f14786c;
    }

    public List<v> W() {
        return this.f14789f;
    }

    public List<w> X() {
        return this.f14787d;
    }

    public Integer Y() {
        return this.f14791m;
    }

    public y Z() {
        return this.f14784a;
    }

    public Double a0() {
        return this.f14788e;
    }

    public e0 b0() {
        return this.f14792n;
    }

    public a0 c0() {
        return this.f14785b;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return com.google.android.gms.common.internal.p.b(this.f14784a, uVar.f14784a) && com.google.android.gms.common.internal.p.b(this.f14785b, uVar.f14785b) && Arrays.equals(this.f14786c, uVar.f14786c) && com.google.android.gms.common.internal.p.b(this.f14788e, uVar.f14788e) && this.f14787d.containsAll(uVar.f14787d) && uVar.f14787d.containsAll(this.f14787d) && (((list = this.f14789f) == null && uVar.f14789f == null) || (list != null && (list2 = uVar.f14789f) != null && list.containsAll(list2) && uVar.f14789f.containsAll(this.f14789f))) && com.google.android.gms.common.internal.p.b(this.f14790l, uVar.f14790l) && com.google.android.gms.common.internal.p.b(this.f14791m, uVar.f14791m) && com.google.android.gms.common.internal.p.b(this.f14792n, uVar.f14792n) && com.google.android.gms.common.internal.p.b(this.f14793o, uVar.f14793o) && com.google.android.gms.common.internal.p.b(this.f14794p, uVar.f14794p);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14784a, this.f14785b, Integer.valueOf(Arrays.hashCode(this.f14786c)), this.f14787d, this.f14788e, this.f14789f, this.f14790l, this.f14791m, this.f14792n, this.f14793o, this.f14794p);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 2, Z(), i10, false);
        d4.c.C(parcel, 3, c0(), i10, false);
        d4.c.k(parcel, 4, V(), false);
        d4.c.I(parcel, 5, X(), false);
        d4.c.o(parcel, 6, a0(), false);
        d4.c.I(parcel, 7, W(), false);
        d4.c.C(parcel, 8, U(), i10, false);
        d4.c.w(parcel, 9, Y(), false);
        d4.c.C(parcel, 10, b0(), i10, false);
        d4.c.E(parcel, 11, S(), false);
        d4.c.C(parcel, 12, T(), i10, false);
        d4.c.b(parcel, iA);
    }
}
