package q4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class m extends n {
    public static final Parcelable.Creator<m> CREATOR = new x1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f14740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f14741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14742c;

    public m(x xVar, Uri uri, byte[] bArr) {
        this.f14740a = (x) com.google.android.gms.common.internal.r.l(xVar);
        V(uri);
        this.f14741b = uri;
        W(bArr);
        this.f14742c = bArr;
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
        return this.f14742c;
    }

    public Uri T() {
        return this.f14741b;
    }

    public x U() {
        return this.f14740a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return com.google.android.gms.common.internal.p.b(this.f14740a, mVar.f14740a) && com.google.android.gms.common.internal.p.b(this.f14741b, mVar.f14741b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14740a, this.f14741b);
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
