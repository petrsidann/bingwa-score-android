package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class d extends d4.a {
    public static final Parcelable.Creator<d> CREATOR = new m1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f14679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b2 f14680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f14681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h2 f14682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k0 f14683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m0 f14684f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d2 f14685l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p0 f14686m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final s f14687n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final r0 f14688o;

    public d(r rVar, b2 b2Var, f0 f0Var, h2 h2Var, k0 k0Var, m0 m0Var, d2 d2Var, p0 p0Var, s sVar, r0 r0Var) {
        this.f14679a = rVar;
        this.f14681c = f0Var;
        this.f14680b = b2Var;
        this.f14682d = h2Var;
        this.f14683e = k0Var;
        this.f14684f = m0Var;
        this.f14685l = d2Var;
        this.f14686m = p0Var;
        this.f14687n = sVar;
        this.f14688o = r0Var;
    }

    public r S() {
        return this.f14679a;
    }

    public f0 T() {
        return this.f14681c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return com.google.android.gms.common.internal.p.b(this.f14679a, dVar.f14679a) && com.google.android.gms.common.internal.p.b(this.f14680b, dVar.f14680b) && com.google.android.gms.common.internal.p.b(this.f14681c, dVar.f14681c) && com.google.android.gms.common.internal.p.b(this.f14682d, dVar.f14682d) && com.google.android.gms.common.internal.p.b(this.f14683e, dVar.f14683e) && com.google.android.gms.common.internal.p.b(this.f14684f, dVar.f14684f) && com.google.android.gms.common.internal.p.b(this.f14685l, dVar.f14685l) && com.google.android.gms.common.internal.p.b(this.f14686m, dVar.f14686m) && com.google.android.gms.common.internal.p.b(this.f14687n, dVar.f14687n) && com.google.android.gms.common.internal.p.b(this.f14688o, dVar.f14688o);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14679a, this.f14680b, this.f14681c, this.f14682d, this.f14683e, this.f14684f, this.f14685l, this.f14686m, this.f14687n, this.f14688o);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 2, S(), i10, false);
        d4.c.C(parcel, 3, this.f14680b, i10, false);
        d4.c.C(parcel, 4, T(), i10, false);
        d4.c.C(parcel, 5, this.f14682d, i10, false);
        d4.c.C(parcel, 6, this.f14683e, i10, false);
        d4.c.C(parcel, 7, this.f14684f, i10, false);
        d4.c.C(parcel, 8, this.f14685l, i10, false);
        d4.c.C(parcel, 9, this.f14686m, i10, false);
        d4.c.C(parcel, 10, this.f14687n, i10, false);
        d4.c.C(parcel, 11, this.f14688o, i10, false);
        d4.c.b(parcel, iA);
    }
}
