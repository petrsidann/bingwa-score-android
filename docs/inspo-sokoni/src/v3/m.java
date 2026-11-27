package v3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class m extends d4.a {
    public static final Parcelable.Creator<m> CREATOR = new g0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17182b;

    public m(String str, String str2) {
        this.f17181a = com.google.android.gms.common.internal.r.g(((String) com.google.android.gms.common.internal.r.m(str, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
        this.f17182b = com.google.android.gms.common.internal.r.f(str2);
    }

    public String S() {
        return this.f17181a;
    }

    public String T() {
        return this.f17182b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return com.google.android.gms.common.internal.p.b(this.f17181a, mVar.f17181a) && com.google.android.gms.common.internal.p.b(this.f17182b, mVar.f17182b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f17181a, this.f17182b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, S(), false);
        d4.c.E(parcel, 2, T(), false);
        d4.c.b(parcel, iA);
    }
}
