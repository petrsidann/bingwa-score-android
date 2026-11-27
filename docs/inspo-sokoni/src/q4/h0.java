package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class h0 extends d4.a {
    public static final Parcelable.Creator<h0> CREATOR = new k1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final short f14721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f14722c;

    public h0(int i10, short s10, short s11) {
        this.f14720a = i10;
        this.f14721b = s10;
        this.f14722c = s11;
    }

    public short S() {
        return this.f14721b;
    }

    public short T() {
        return this.f14722c;
    }

    public int U() {
        return this.f14720a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.f14720a == h0Var.f14720a && this.f14721b == h0Var.f14721b && this.f14722c == h0Var.f14722c;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(Integer.valueOf(this.f14720a), Short.valueOf(this.f14721b), Short.valueOf(this.f14722c));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, U());
        d4.c.D(parcel, 2, S());
        d4.c.D(parcel, 3, T());
        d4.c.b(parcel, iA);
    }
}
