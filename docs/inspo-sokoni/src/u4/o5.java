package u4;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbu;
import com.google.android.gms.internal.measurement.zzbw;

/* JADX INFO: loaded from: classes.dex */
public final class o5 extends zzbu implements m5 {
    public o5(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // u4.m5
    public final void w(de deVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, deVar);
        zzc(2, parcelB_);
    }
}
