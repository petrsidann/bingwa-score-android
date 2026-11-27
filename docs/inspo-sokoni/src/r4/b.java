package r4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.fido.common.Transport;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class b extends d4.a {
    public static final Parcelable.Creator<b> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f15011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f15012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f15013d;

    public b(int i10, byte[] bArr, String str, List list) {
        this.f15010a = i10;
        this.f15011b = bArr;
        try {
            this.f15012c = c.d(str);
            this.f15013d = list;
        } catch (c.a e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public byte[] S() {
        return this.f15011b;
    }

    public c T() {
        return this.f15012c;
    }

    public List<Transport> U() {
        return this.f15013d;
    }

    public int V() {
        return this.f15010a;
    }

    public boolean equals(Object obj) {
        List list;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Arrays.equals(this.f15011b, bVar.f15011b) || !this.f15012c.equals(bVar.f15012c)) {
            return false;
        }
        List list2 = this.f15013d;
        if (list2 == null && bVar.f15013d == null) {
            return true;
        }
        return list2 != null && (list = bVar.f15013d) != null && list2.containsAll(list) && bVar.f15013d.containsAll(this.f15013d);
    }

    public int hashCode() {
        return p.c(Integer.valueOf(Arrays.hashCode(this.f15011b)), this.f15012c, this.f15013d);
    }

    public String toString() {
        List list = this.f15013d;
        return String.format("{keyHandle: %s, version: %s, transports: %s}", j4.c.c(this.f15011b), this.f15012c, list == null ? "null" : list.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, V());
        d4.c.k(parcel, 2, S(), false);
        d4.c.E(parcel, 3, this.f15012c.toString(), false);
        d4.c.I(parcel, 4, U(), false);
        d4.c.b(parcel, iA);
    }
}
