package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class q1 extends d4.a {
    public static final Parcelable.Creator<q1> CREATOR = new r1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14772b;

    public q1(boolean z10, byte[] bArr) {
        this.f14771a = z10;
        this.f14772b = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q1)) {
            return false;
        }
        q1 q1Var = (q1) obj;
        return this.f14771a == q1Var.f14771a && Arrays.equals(this.f14772b, q1Var.f14772b);
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.c(Boolean.valueOf(this.f14771a), this.f14772b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.g(parcel, 1, this.f14771a);
        d4.c.k(parcel, 2, this.f14772b, false);
        d4.c.b(parcel, iA);
    }
}
