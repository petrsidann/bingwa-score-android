package q4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.internal.fido.zzbc;
import com.google.android.gms.internal.fido.zzh;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class v extends d4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f14796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f14798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzbc f14795d = zzbc.zzk(zzh.zza, zzh.zzb);
    public static final Parcelable.Creator<v> CREATOR = new v0();

    public v(String str, byte[] bArr, List<Transport> list) {
        com.google.android.gms.common.internal.r.l(str);
        try {
            this.f14796a = z.d(str);
            this.f14797b = (byte[]) com.google.android.gms.common.internal.r.l(bArr);
            this.f14798c = list;
        } catch (z.a e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public byte[] S() {
        return this.f14797b;
    }

    public List<Transport> T() {
        return this.f14798c;
    }

    public String U() {
        return this.f14796a.toString();
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (!this.f14796a.equals(vVar.f14796a) || !Arrays.equals(this.f14797b, vVar.f14797b)) {
            return false;
        }
        List list2 = this.f14798c;
        if (list2 == null && vVar.f14798c == null) {
            return true;
        }
        return list2 != null && (list = vVar.f14798c) != null && list2.containsAll(list) && vVar.f14798c.containsAll(this.f14798c);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14796a, Integer.valueOf(Arrays.hashCode(this.f14797b)), this.f14798c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 2, U(), false);
        d4.c.k(parcel, 3, S(), false);
        d4.c.I(parcel, 4, T(), false);
        d4.c.b(parcel, iA);
    }
}
