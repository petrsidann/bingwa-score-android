package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class o1 extends d4.a {
    public static final Parcelable.Creator<o1> CREATOR = new p1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14746b;

    public o1(byte[] bArr, byte[] bArr2) {
        this.f14745a = bArr;
        this.f14746b = bArr2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return Arrays.equals(this.f14745a, o1Var.f14745a) && Arrays.equals(this.f14746b, o1Var.f14746b);
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14745a, this.f14746b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.k(parcel, 1, this.f14745a, false);
        d4.c.k(parcel, 2, this.f14746b, false);
        d4.c.b(parcel, iA);
    }
}
