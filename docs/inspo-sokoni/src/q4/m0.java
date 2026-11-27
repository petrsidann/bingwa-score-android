package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m0 extends d4.a {
    public static final Parcelable.Creator<m0> CREATOR = new n0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14743a;

    public m0(boolean z10) {
        this.f14743a = ((Boolean) com.google.android.gms.common.internal.r.l(Boolean.valueOf(z10))).booleanValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof m0) && this.f14743a == ((m0) obj).f14743a;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.c(Boolean.valueOf(this.f14743a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.g(parcel, 1, this.f14743a);
        d4.c.b(parcel, iA);
    }
}
