package c4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class d extends d4.a {
    public static final Parcelable.Creator<d> CREATOR = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public final int f3356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3357c;

    public d(String str, int i10, long j10) {
        this.f3355a = str;
        this.f3356b = i10;
        this.f3357c = j10;
    }

    public d(String str, long j10) {
        this.f3355a = str;
        this.f3357c = j10;
        this.f3356b = -1;
    }

    public String S() {
        return this.f3355a;
    }

    public long T() {
        long j10 = this.f3357c;
        return j10 == -1 ? this.f3356b : j10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (((S() != null && S().equals(dVar.S())) || (S() == null && dVar.S() == null)) && T() == dVar.T()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.c(S(), Long.valueOf(T()));
    }

    public final String toString() {
        com.google.android.gms.common.internal.p.a aVarD = com.google.android.gms.common.internal.p.d(this);
        aVarD.a("name", S());
        aVarD.a("version", Long.valueOf(T()));
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, S(), false);
        d4.c.t(parcel, 2, this.f3356b);
        d4.c.x(parcel, 3, T());
        d4.c.b(parcel, iA);
    }
}
