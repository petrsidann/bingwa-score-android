package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class r extends d4.a {
    public static final Parcelable.Creator<r> CREATOR = new g2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14773a;

    public r(String str) {
        this.f14773a = (String) com.google.android.gms.common.internal.r.l(str);
    }

    public String S() {
        return this.f14773a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f14773a.equals(((r) obj).f14773a);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14773a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 2, S(), false);
        d4.c.b(parcel, iA);
    }
}
