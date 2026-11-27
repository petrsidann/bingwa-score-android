package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class f0 extends d4.a {
    public static final Parcelable.Creator<f0> CREATOR = new e1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14709a;

    public f0(boolean z10) {
        this.f14709a = z10;
    }

    public boolean S() {
        return this.f14709a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f0) && this.f14709a == ((f0) obj).f14709a;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(Boolean.valueOf(this.f14709a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.g(parcel, 1, S());
        d4.c.b(parcel, iA);
    }
}
