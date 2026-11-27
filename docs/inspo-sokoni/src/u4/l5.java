package u4;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzbx;

/* JADX INFO: loaded from: classes.dex */
public abstract class l5 extends zzbx implements m5 {
    public l5() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 2) {
            return false;
        }
        de deVar = (de) zzbw.zza(parcel, de.CREATOR);
        zzbw.zzb(parcel);
        w(deVar);
        return true;
    }
}
