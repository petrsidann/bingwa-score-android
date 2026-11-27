package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class p0 extends d4.a {
    public static final Parcelable.Creator<p0> CREATOR = new q0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14756a;

    public p0(String str) {
        this.f14756a = (String) com.google.android.gms.common.internal.r.l(str);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p0) {
            return this.f14756a.equals(((p0) obj).f14756a);
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14756a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f14756a, false);
        d4.c.b(parcel, iA);
    }
}
