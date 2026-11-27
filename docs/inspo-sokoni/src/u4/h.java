package u4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class h extends d4.a {
    public static final Parcelable.Creator<h> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ze f16267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f16268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f16269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16270f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n0 f16271l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f16272m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public n0 f16273n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f16274o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public n0 f16275p;

    public h(String str, String str2, ze zeVar, long j10, boolean z10, String str3, n0 n0Var, long j11, n0 n0Var2, long j12, n0 n0Var3) {
        this.f16265a = str;
        this.f16266b = str2;
        this.f16267c = zeVar;
        this.f16268d = j10;
        this.f16269e = z10;
        this.f16270f = str3;
        this.f16271l = n0Var;
        this.f16272m = j11;
        this.f16273n = n0Var2;
        this.f16274o = j12;
        this.f16275p = n0Var3;
    }

    public h(h hVar) {
        com.google.android.gms.common.internal.r.l(hVar);
        this.f16265a = hVar.f16265a;
        this.f16266b = hVar.f16266b;
        this.f16267c = hVar.f16267c;
        this.f16268d = hVar.f16268d;
        this.f16269e = hVar.f16269e;
        this.f16270f = hVar.f16270f;
        this.f16271l = hVar.f16271l;
        this.f16272m = hVar.f16272m;
        this.f16273n = hVar.f16273n;
        this.f16274o = hVar.f16274o;
        this.f16275p = hVar.f16275p;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 2, this.f16265a, false);
        d4.c.E(parcel, 3, this.f16266b, false);
        d4.c.C(parcel, 4, this.f16267c, i10, false);
        d4.c.x(parcel, 5, this.f16268d);
        d4.c.g(parcel, 6, this.f16269e);
        d4.c.E(parcel, 7, this.f16270f, false);
        d4.c.C(parcel, 8, this.f16271l, i10, false);
        d4.c.x(parcel, 9, this.f16272m);
        d4.c.C(parcel, 10, this.f16273n, i10, false);
        d4.c.x(parcel, 11, this.f16274o);
        d4.c.C(parcel, 12, this.f16275p, i10, false);
        d4.c.b(parcel, iA);
    }
}
