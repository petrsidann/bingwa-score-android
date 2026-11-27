package u4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class n0 extends d4.a {
    public static final Parcelable.Creator<n0> CREATOR = new m0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f16570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f16572d;

    public n0(String str, i0 i0Var, String str2, long j10) {
        this.f16569a = str;
        this.f16570b = i0Var;
        this.f16571c = str2;
        this.f16572d = j10;
    }

    public n0(n0 n0Var, long j10) {
        com.google.android.gms.common.internal.r.l(n0Var);
        this.f16569a = n0Var.f16569a;
        this.f16570b = n0Var.f16570b;
        this.f16571c = n0Var.f16571c;
        this.f16572d = j10;
    }

    public final String toString() {
        return "origin=" + this.f16571c + ",name=" + this.f16569a + ",params=" + String.valueOf(this.f16570b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 2, this.f16569a, false);
        d4.c.C(parcel, 3, this.f16570b, i10, false);
        d4.c.E(parcel, 4, this.f16571c, false);
        d4.c.x(parcel, 5, this.f16572d);
        d4.c.b(parcel, iA);
    }
}
