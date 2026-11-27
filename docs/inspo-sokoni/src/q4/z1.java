package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class z1 extends d4.a {
    public static final Parcelable.Creator<z1> CREATOR = new a2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14819d;

    public z1(long j10, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f14816a = j10;
        this.f14817b = (byte[]) com.google.android.gms.common.internal.r.l(bArr);
        this.f14818c = (byte[]) com.google.android.gms.common.internal.r.l(bArr2);
        this.f14819d = (byte[]) com.google.android.gms.common.internal.r.l(bArr3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z1)) {
            return false;
        }
        z1 z1Var = (z1) obj;
        return this.f14816a == z1Var.f14816a && Arrays.equals(this.f14817b, z1Var.f14817b) && Arrays.equals(this.f14818c, z1Var.f14818c) && Arrays.equals(this.f14819d, z1Var.f14819d);
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.c(Long.valueOf(this.f14816a), this.f14817b, this.f14818c, this.f14819d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.x(parcel, 1, this.f14816a);
        d4.c.k(parcel, 2, this.f14817b, false);
        d4.c.k(parcel, 3, this.f14818c, false);
        d4.c.k(parcel, 4, this.f14819d, false);
        d4.c.b(parcel, iA);
    }
}
