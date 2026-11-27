package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class w extends d4.a {
    public static final Parcelable.Creator<w> CREATOR = new w0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f14799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f14800b;

    public w(String str, int i10) {
        com.google.android.gms.common.internal.r.l(str);
        try {
            this.f14799a = z.d(str);
            com.google.android.gms.common.internal.r.l(Integer.valueOf(i10));
            try {
                this.f14800b = o.a(i10);
            } catch (o.a e10) {
                throw new IllegalArgumentException(e10);
            }
        } catch (z.a e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public int S() {
        return this.f14800b.b();
    }

    public String T() {
        return this.f14799a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f14799a.equals(wVar.f14799a) && this.f14800b.equals(wVar.f14800b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14799a, this.f14800b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 2, T(), false);
        d4.c.w(parcel, 3, Integer.valueOf(S()), false);
        d4.c.b(parcel, iA);
    }
}
