package n4;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class h extends zza {
    public h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final m4.a b(m4.a aVar, String str, int i10, m4.a aVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i10);
        zzc.zze(parcelZza, aVar2);
        Parcel parcelZzB = zzB(2, parcelZza);
        m4.a aVarB = m4.a.AbstractBinderC0217a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final m4.a f(m4.a aVar, String str, int i10, m4.a aVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i10);
        zzc.zze(parcelZza, aVar2);
        Parcel parcelZzB = zzB(3, parcelZza);
        m4.a aVarB = m4.a.AbstractBinderC0217a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }
}
