package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class r0 extends d4.a {
    public static final Parcelable.Creator<r0> CREATOR = new s0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f14774a;

    public r0(byte[][] bArr) {
        com.google.android.gms.common.internal.r.a(bArr != null);
        com.google.android.gms.common.internal.r.a(1 == ((bArr.length & 1) ^ 1));
        int i10 = 0;
        while (i10 < bArr.length) {
            com.google.android.gms.common.internal.r.a(i10 == 0 || bArr[i10] != null);
            int i11 = i10 + 1;
            com.google.android.gms.common.internal.r.a(bArr[i11] != null);
            int length = bArr[i11].length;
            com.google.android.gms.common.internal.r.a(length == 32 || length == 64);
            i10 += 2;
        }
        this.f14774a = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof r0) {
            return Arrays.deepEquals(this.f14774a, ((r0) obj).f14774a);
        }
        return false;
    }

    public final int hashCode() {
        int iC = 0;
        for (byte[] bArr : this.f14774a) {
            iC ^= com.google.android.gms.common.internal.p.c(bArr);
        }
        return iC;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.l(parcel, 1, this.f14774a, false);
        d4.c.b(parcel, iA);
    }
}
