package q4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class l extends n {
    public static final Parcelable.Creator<l> CREATOR = new w1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f14737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f14738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14739c;

    public l(u uVar, Uri uri, byte[] bArr) {
        this.f14737a = (u) com.google.android.gms.common.internal.r.l(uVar);
        V(uri);
        this.f14738b = uri;
        W(bArr);
        this.f14739c = bArr;
    }

    public static Uri V(Uri uri) {
        com.google.android.gms.common.internal.r.l(uri);
        com.google.android.gms.common.internal.r.b(uri.getScheme() != null, "origin scheme must be non-empty");
        com.google.android.gms.common.internal.r.b(uri.getAuthority() != null, "origin authority must be non-empty");
        return uri;
    }

    public static byte[] W(byte[] bArr) {
        boolean z10 = true;
        if (bArr != null && bArr.length != 32) {
            z10 = false;
        }
        com.google.android.gms.common.internal.r.b(z10, "clientDataHash must be 32 bytes long");
        return bArr;
    }

    public byte[] S() {
        return this.f14739c;
    }

    public Uri T() {
        return this.f14738b;
    }

    public u U() {
        return this.f14737a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return com.google.android.gms.common.internal.p.b(this.f14737a, lVar.f14737a) && com.google.android.gms.common.internal.p.b(this.f14738b, lVar.f14738b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14737a, this.f14738b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 2, U(), i10, false);
        d4.c.C(parcel, 3, T(), i10, false);
        d4.c.k(parcel, 4, S(), false);
        d4.c.b(parcel, iA);
    }
}
