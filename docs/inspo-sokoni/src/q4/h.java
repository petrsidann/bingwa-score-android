package q4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.google.android.gms.internal.fido.zzch;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class h extends j {
    public static final Parcelable.Creator<h> CREATOR = new t1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f14719d;

    public h(byte[] bArr, byte[] bArr2, byte[] bArr3, String[] strArr) {
        this.f14716a = (byte[]) com.google.android.gms.common.internal.r.l(bArr);
        this.f14717b = (byte[]) com.google.android.gms.common.internal.r.l(bArr2);
        this.f14718c = (byte[]) com.google.android.gms.common.internal.r.l(bArr3);
        this.f14719d = (String[]) com.google.android.gms.common.internal.r.l(strArr);
    }

    public byte[] S() {
        return this.f14718c;
    }

    public byte[] T() {
        return this.f14717b;
    }

    @Deprecated
    public byte[] U() {
        return this.f14716a;
    }

    public String[] V() {
        return this.f14719d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Arrays.equals(this.f14716a, hVar.f14716a) && Arrays.equals(this.f14717b, hVar.f14717b) && Arrays.equals(this.f14718c, hVar.f14718c);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(Integer.valueOf(Arrays.hashCode(this.f14716a)), Integer.valueOf(Arrays.hashCode(this.f14717b)), Integer.valueOf(Arrays.hashCode(this.f14718c)));
    }

    public String toString() {
        zzam zzamVarZza = zzan.zza(this);
        zzch zzchVarZzf = zzch.zzf();
        byte[] bArr = this.f14716a;
        zzamVarZza.zzb("keyHandle", zzchVarZzf.zzg(bArr, 0, bArr.length));
        zzch zzchVarZzf2 = zzch.zzf();
        byte[] bArr2 = this.f14717b;
        zzamVarZza.zzb("clientDataJSON", zzchVarZzf2.zzg(bArr2, 0, bArr2.length));
        zzch zzchVarZzf3 = zzch.zzf();
        byte[] bArr3 = this.f14718c;
        zzamVarZza.zzb("attestationObject", zzchVarZzf3.zzg(bArr3, 0, bArr3.length));
        zzamVarZza.zzb("transports", Arrays.toString(this.f14719d));
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.k(parcel, 2, U(), false);
        d4.c.k(parcel, 3, T(), false);
        d4.c.k(parcel, 4, S(), false);
        d4.c.F(parcel, 5, V(), false);
        d4.c.b(parcel, iA);
    }
}
