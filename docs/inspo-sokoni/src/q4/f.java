package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class f extends d4.a {
    public static final Parcelable.Creator<f> CREATOR = new n1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14708a;

    public f(boolean z10) {
        this.f14708a = z10;
    }

    public boolean S() {
        return this.f14708a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f14708a == ((f) obj).f14708a;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(Boolean.valueOf(this.f14708a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.g(parcel, 1, S());
        d4.c.b(parcel, iA);
    }
}
