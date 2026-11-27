package x4;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

/* JADX INFO: loaded from: classes.dex */
public final class g extends zaa {
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void b(j jVar, f fVar) {
        Parcel parcelZaa = zaa();
        zac.zac(parcelZaa, jVar);
        zac.zad(parcelZaa, fVar);
        zac(12, parcelZaa);
    }
}
