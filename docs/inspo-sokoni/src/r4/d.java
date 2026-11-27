package r4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class d extends d4.a {
    public static final Parcelable.Creator<d> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f15020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f15021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15022d;

    public d(int i10, String str, byte[] bArr, String str2) {
        this.f15019a = i10;
        try {
            this.f15020b = c.d(str);
            this.f15021c = bArr;
            this.f15022d = str2;
        } catch (c.a e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public String S() {
        return this.f15022d;
    }

    public byte[] T() {
        return this.f15021c;
    }

    public int U() {
        return this.f15019a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!Arrays.equals(this.f15021c, dVar.f15021c) || this.f15020b != dVar.f15020b) {
            return false;
        }
        String str = this.f15022d;
        String str2 = dVar.f15022d;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.f15021c) + 31) * 31) + this.f15020b.hashCode();
        String str = this.f15022d;
        return (iHashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, U());
        d4.c.E(parcel, 2, this.f15020b.toString(), false);
        d4.c.k(parcel, 3, T(), false);
        d4.c.E(parcel, 4, S(), false);
        d4.c.b(parcel, iA);
    }
}
