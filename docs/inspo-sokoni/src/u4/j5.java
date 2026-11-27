package u4;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbu;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class j5 extends zzbu implements h5 {
    public j5(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // u4.h5
    public final void zza(List<sd> list) {
        Parcel parcelB_ = b_();
        parcelB_.writeTypedList(list);
        zzc(2, parcelB_);
    }
}
