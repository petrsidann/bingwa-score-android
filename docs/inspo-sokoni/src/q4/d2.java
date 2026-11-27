package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d2 extends d4.a {
    public static final Parcelable.Creator<d2> CREATOR = new e2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14694a;

    public d2(boolean z10) {
        this.f14694a = ((Boolean) com.google.android.gms.common.internal.r.l(Boolean.valueOf(z10))).booleanValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof d2) && this.f14694a == ((d2) obj).f14694a;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.c(Boolean.valueOf(this.f14694a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.g(parcel, 1, this.f14694a);
        d4.c.b(parcel, iA);
    }
}
