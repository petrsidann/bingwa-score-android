package e4;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

/* JADX INFO: loaded from: classes.dex */
public final class a extends zaa {
    public a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void b(v vVar) {
        Parcel parcelZaa = zaa();
        zac.zac(parcelZaa, vVar);
        zad(1, parcelZaa);
    }
}
