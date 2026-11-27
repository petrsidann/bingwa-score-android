package n4;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class g extends zza {
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int b() {
        Parcel parcelZzB = zzB(6, zza());
        int i10 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i10;
    }

    public final int f(m4.a aVar, String str, boolean z10) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z10 ? 1 : 0);
        Parcel parcelZzB = zzB(3, parcelZza);
        int i10 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i10;
    }

    public final int i(m4.a aVar, String str, boolean z10) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z10 ? 1 : 0);
        Parcel parcelZzB = zzB(5, parcelZza);
        int i10 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i10;
    }

    public final m4.a k1(m4.a aVar, String str, int i10) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i10);
        Parcel parcelZzB = zzB(2, parcelZza);
        m4.a aVarB = m4.a.AbstractBinderC0217a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final m4.a l1(m4.a aVar, String str, int i10, m4.a aVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i10);
        zzc.zze(parcelZza, aVar2);
        Parcel parcelZzB = zzB(8, parcelZza);
        m4.a aVarB = m4.a.AbstractBinderC0217a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final m4.a m1(m4.a aVar, String str, int i10) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i10);
        Parcel parcelZzB = zzB(4, parcelZza);
        m4.a aVarB = m4.a.AbstractBinderC0217a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final m4.a n1(m4.a aVar, String str, boolean z10, long j10) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z10 ? 1 : 0);
        parcelZza.writeLong(j10);
        Parcel parcelZzB = zzB(7, parcelZza);
        m4.a aVarB = m4.a.AbstractBinderC0217a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }
}
