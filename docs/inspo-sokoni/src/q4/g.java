package q4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.google.android.gms.internal.fido.zzch;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class g extends j {
    public static final Parcelable.Creator<g> CREATOR = new s1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f14714e;

    public g(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f14710a = (byte[]) com.google.android.gms.common.internal.r.l(bArr);
        this.f14711b = (byte[]) com.google.android.gms.common.internal.r.l(bArr2);
        this.f14712c = (byte[]) com.google.android.gms.common.internal.r.l(bArr3);
        this.f14713d = (byte[]) com.google.android.gms.common.internal.r.l(bArr4);
        this.f14714e = bArr5;
    }

    public byte[] S() {
        return this.f14712c;
    }

    public byte[] T() {
        return this.f14711b;
    }

    @Deprecated
    public byte[] U() {
        return this.f14710a;
    }

    public byte[] V() {
        return this.f14713d;
    }

    public byte[] W() {
        return this.f14714e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Arrays.equals(this.f14710a, gVar.f14710a) && Arrays.equals(this.f14711b, gVar.f14711b) && Arrays.equals(this.f14712c, gVar.f14712c) && Arrays.equals(this.f14713d, gVar.f14713d) && Arrays.equals(this.f14714e, gVar.f14714e);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(Integer.valueOf(Arrays.hashCode(this.f14710a)), Integer.valueOf(Arrays.hashCode(this.f14711b)), Integer.valueOf(Arrays.hashCode(this.f14712c)), Integer.valueOf(Arrays.hashCode(this.f14713d)), Integer.valueOf(Arrays.hashCode(this.f14714e)));
    }

    public String toString() {
        zzam zzamVarZza = zzan.zza(this);
        zzch zzchVarZzf = zzch.zzf();
        byte[] bArr = this.f14710a;
        zzamVarZza.zzb("keyHandle", zzchVarZzf.zzg(bArr, 0, bArr.length));
        zzch zzchVarZzf2 = zzch.zzf();
        byte[] bArr2 = this.f14711b;
        zzamVarZza.zzb("clientDataJSON", zzchVarZzf2.zzg(bArr2, 0, bArr2.length));
        zzch zzchVarZzf3 = zzch.zzf();
        byte[] bArr3 = this.f14712c;
        zzamVarZza.zzb("authenticatorData", zzchVarZzf3.zzg(bArr3, 0, bArr3.length));
        zzch zzchVarZzf4 = zzch.zzf();
        byte[] bArr4 = this.f14713d;
        zzamVarZza.zzb("signature", zzchVarZzf4.zzg(bArr4, 0, bArr4.length));
        byte[] bArr5 = this.f14714e;
        if (bArr5 != null) {
            zzamVarZza.zzb("userHandle", zzch.zzf().zzg(bArr5, 0, bArr5.length));
        }
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.k(parcel, 2, U(), false);
        d4.c.k(parcel, 3, T(), false);
        d4.c.k(parcel, 4, S(), false);
        d4.c.k(parcel, 5, V(), false);
        d4.c.k(parcel, 6, W(), false);
        d4.c.b(parcel, iA);
    }
}
