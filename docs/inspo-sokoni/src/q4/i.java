package q4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;

/* JADX INFO: loaded from: classes.dex */
public class i extends j {
    public static final Parcelable.Creator<i> CREATOR = new u1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f14729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14731c;

    public i(int i10, String str, int i11) {
        try {
            this.f14729a = q.h(i10);
            this.f14730b = str;
            this.f14731c = i11;
        } catch (q.a e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public int S() {
        return this.f14729a.d();
    }

    public String T() {
        return this.f14730b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return com.google.android.gms.common.internal.p.b(this.f14729a, iVar.f14729a) && com.google.android.gms.common.internal.p.b(this.f14730b, iVar.f14730b) && com.google.android.gms.common.internal.p.b(Integer.valueOf(this.f14731c), Integer.valueOf(iVar.f14731c));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14729a, this.f14730b, Integer.valueOf(this.f14731c));
    }

    public String toString() {
        zzam zzamVarZza = zzan.zza(this);
        zzamVarZza.zza("errorCode", this.f14729a.d());
        String str = this.f14730b;
        if (str != null) {
            zzamVarZza.zzb("errorMessage", str);
        }
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 2, S());
        d4.c.E(parcel, 3, T(), false);
        d4.c.t(parcel, 4, this.f14731c);
        d4.c.b(parcel, iA);
    }
}
