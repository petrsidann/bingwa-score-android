package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class y extends d4.a {
    public static final Parcelable.Creator<y> CREATOR = new y0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14812c;

    public y(String str, String str2, String str3) {
        this.f14810a = (String) com.google.android.gms.common.internal.r.l(str);
        this.f14811b = (String) com.google.android.gms.common.internal.r.l(str2);
        this.f14812c = str3;
    }

    public String S() {
        return this.f14812c;
    }

    public String T() {
        return this.f14810a;
    }

    public String U() {
        return this.f14811b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return com.google.android.gms.common.internal.p.b(this.f14810a, yVar.f14810a) && com.google.android.gms.common.internal.p.b(this.f14811b, yVar.f14811b) && com.google.android.gms.common.internal.p.b(this.f14812c, yVar.f14812c);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14810a, this.f14811b, this.f14812c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 2, T(), false);
        d4.c.E(parcel, 3, U(), false);
        d4.c.E(parcel, 4, S(), false);
        d4.c.b(parcel, iA);
    }
}
