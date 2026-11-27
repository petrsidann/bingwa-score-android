package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class s extends d4.a {
    public static final Parcelable.Creator<s> CREATOR = new o0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14775a;

    public s(boolean z10) {
        this.f14775a = z10;
    }

    public boolean S() {
        return this.f14775a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && this.f14775a == ((s) obj).S();
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(Boolean.valueOf(this.f14775a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.g(parcel, 1, S());
        d4.c.b(parcel, iA);
    }
}
