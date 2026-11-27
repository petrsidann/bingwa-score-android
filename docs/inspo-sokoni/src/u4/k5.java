package u4;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzbx;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class k5 extends zzbx implements h5 {
    public k5() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 2) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(sd.CREATOR);
        zzbw.zzb(parcel);
        zza(arrayListCreateTypedArrayList);
        return true;
    }
}
