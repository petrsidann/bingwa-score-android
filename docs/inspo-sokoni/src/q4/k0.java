package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends d4.a {
    public static final Parcelable.Creator<k0> CREATOR = new l0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14736a;

    public k0(long j10) {
        this.f14736a = ((Long) com.google.android.gms.common.internal.r.l(Long.valueOf(j10))).longValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof k0) && this.f14736a == ((k0) obj).f14736a;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.c(Long.valueOf(this.f14736a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.x(parcel, 1, this.f14736a);
        d4.c.b(parcel, iA);
    }
}
