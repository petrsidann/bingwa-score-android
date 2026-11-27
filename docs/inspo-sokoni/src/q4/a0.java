package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a0 extends d4.a {
    public static final Parcelable.Creator<a0> CREATOR = new a1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14658d;

    public a0(byte[] bArr, String str, String str2, String str3) {
        this.f14655a = (byte[]) com.google.android.gms.common.internal.r.l(bArr);
        this.f14656b = (String) com.google.android.gms.common.internal.r.l(str);
        this.f14657c = str2;
        this.f14658d = (String) com.google.android.gms.common.internal.r.l(str3);
    }

    public String S() {
        return this.f14657c;
    }

    public byte[] T() {
        return this.f14655a;
    }

    public String U() {
        return this.f14656b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Arrays.equals(this.f14655a, a0Var.f14655a) && com.google.android.gms.common.internal.p.b(this.f14656b, a0Var.f14656b) && com.google.android.gms.common.internal.p.b(this.f14657c, a0Var.f14657c) && com.google.android.gms.common.internal.p.b(this.f14658d, a0Var.f14658d);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14655a, this.f14656b, this.f14657c, this.f14658d);
    }

    public String w() {
        return this.f14658d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.k(parcel, 2, T(), false);
        d4.c.E(parcel, 3, U(), false);
        d4.c.E(parcel, 4, S(), false);
        d4.c.E(parcel, 5, w(), false);
        d4.c.b(parcel, iA);
    }
}
